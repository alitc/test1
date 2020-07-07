package com.lmk.orange.wechat.wechat;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caihl
 *
 */
public class WechatApplet {

    private static Logger logger = LoggerFactory.getLogger(WechatPublic.class);

    private String appid;

    private String secret;

    private RedisTemplate redisTemplate;

    private String redisTokenKey;

    public WechatApplet(String appid,String secret,RedisTemplate redisTemplate,String redisTokenKey){
        this.appid = appid;
        this.secret =secret;
        this.redisTemplate = redisTemplate;
        this.redisTokenKey = redisTokenKey;
    }

    public Map jscode2session(String js_code){

        Map<String,Object> data = new HashMap<String, Object>();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code";

        try {
            // 创建HttpClient实例
            HttpClient client =  HttpClientBuilder.create().build();
            // 根据URL创建HttpGet实例
            HttpGet get = new HttpGet(url);
            // 执行get请求，得到返回体
            HttpResponse response = client.execute(get);
            //返回数据格式化
            String line=null;
            StringBuilder entityStringBuilder=new StringBuilder();
            BufferedReader b = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"),8*1024);
            while ((line=b.readLine())!=null) {
                entityStringBuilder.append(line);
            }
            String result = entityStringBuilder.toString();
            logger.info("小程序登录凭证校验："+result);
            JSONObject resultJsonObject = JSONObject.parseObject(result);
            data.put("openid",resultJsonObject.getString("openid"));
            data.put("session_key",resultJsonObject.getString("session_key"));
            data.put("unionid",resultJsonObject.getString("unionid"))  ;
            data.put("errcode",resultJsonObject.getInteger("errcode")) ;
            data.put("errmsg",resultJsonObject.getString("errmsg"))    ;
        }catch (Exception e){
            logger.error("调用小程序登录凭证校验口异常："+e.getMessage());
            data.put("errcode",-2);
            data.put("errmsg","小程序登录凭证校验口后台异常");
        }

        return data;

    }

}
