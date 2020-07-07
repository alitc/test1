package com.lmk.orange.wechat.wechat;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author caihl
 * @date 2020/4/9 15:39
 */
public class WechatPublic {

    private static Logger logger = LoggerFactory.getLogger(WechatPublic.class);

    private String appid;

    private String secret;

    private RedisTemplate redisTemplate;

    private String redisTokenKey;

    public WechatPublic(String appid,String secret,RedisTemplate redisTemplate,String redisTokenKey){
        this.appid = appid;
        this.secret =secret;
        this.redisTemplate = redisTemplate;
        this.redisTokenKey = redisTokenKey;
    };

    /**
     * 获取token
     * @return
     */
    public Map getAccessToken(){

        Map<String,Object> data = new HashMap<String,Object>();
        String access_token =null  ;
        if(redisTemplate!=null){
            access_token = (String)redisTemplate.opsForValue().get(redisTokenKey);
        }

        if(StringUtils.isEmpty(access_token) ){

            try {
                String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
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
                logger.info("调用公众号授权接口："+result);
                JSONObject resultJsonObject = JSONObject.parseObject(result);

                //获取值
                access_token = (String)resultJsonObject.getString("access_token");
                Long expires_in = (Long)resultJsonObject.getLong("expires_in");
                data.put("access_token",access_token);
                data.put("expires_in",expires_in);
                data.put("errcode",resultJsonObject.getInteger("errcode"));
                data.put("errmsg",resultJsonObject.getString("errmsg"));
                if(!StringUtils.isEmpty(access_token)){
                    expires_in = expires_in-200;
                    if(redisTemplate!=null){
                        redisTemplate.opsForValue().set(redisTokenKey,access_token,expires_in, TimeUnit.SECONDS);
                    }
                }
                return data;
            } catch (Exception e) {
                logger.error("调用公众号授权接口异常："+e.getMessage());
            }

            data.put("errcode",-2);
            data.put("errmsg","获取token异常");

        }else{
            data.put("access_token",access_token);
        }

        return data;

    }

    /**
     * 公众号网页授权
     * @return
     */
    public Map WebAuth(String code){
        Map<String,Object> data = new HashMap<String, Object>();

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
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
            logger.info("调用公众号网页授权接口："+result);
            JSONObject resultJsonObject = JSONObject.parseObject(result);
            data.put("errcode",resultJsonObject.getInteger("errcode")); //错误代码
            data.put("errmsg",resultJsonObject.getString("errmsg"));  //错误描述
            data.put("access_token",resultJsonObject.getString("access_token")); //token
            data.put("expires_in",resultJsonObject.getInteger("expires_in")); //token有效时间
            data.put("refresh_token",resultJsonObject.getString("refresh_token")); //刷新token用
            data.put("openid",resultJsonObject.getString("openid"));//用户唯一标识
            data.put("scope",resultJsonObject.getString("scope")); //用户授权的作用域
        }catch (Exception e){
            logger.error("调用公众号网页授权接口异常："+e.getMessage());
            data.put("errcode",-2);
            data.put("errmsg","获取授权信息异常");
        }
        return data;
    }

    /**
     * 用户授权后获取用户信息
     * @param access_token
     * @param openid
     * @return
     */
    public Map WebAuthGetUserInfo(String access_token,String openid){

        Map<String,Object> data = new HashMap<String, Object>();

        String url = " https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
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
            logger.info("公众号网页授权用户信息："+result);
            JSONObject resultJsonObject = JSONObject.parseObject(result);
            data.put("errcode",resultJsonObject.getInteger("errcode")); //异常代码
            data.put("errmsg",resultJsonObject.getString("errmsg")); //异常描述
            data.put("openid",resultJsonObject.getString("openid")); //唯一标识
            data.put("nickname",resultJsonObject.getString("nickname")); //昵称
            data.put("sex",resultJsonObject.getInteger("sex")); //性别
            data.put("province",resultJsonObject.getString("province"));  //省
            data.put("city",resultJsonObject.getString("city")); //市
            data.put("country",resultJsonObject.getString("country")); //国家
            data.put("privilege",resultJsonObject.getJSONArray("privilege"));//用户特权信息
            data.put("headimgurl",resultJsonObject.getString("headimgurl"));//头像地址
            data.put("unionid",resultJsonObject.getString("unionid"));//开放平台唯一id
        }catch (Exception e){
            logger.error("公众号网页授权获取用户信息异常："+e.getMessage());
            data.put("errcode",-2);
            data.put("errmsg","调用公众号用户授权用户信息异常");
        }
        return data;
     }

}
