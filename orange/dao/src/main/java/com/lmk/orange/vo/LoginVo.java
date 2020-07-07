package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author WangShijun
 * @date 2020/5/4 9:28
 */
@Data
@ApiModel("登陆信息")
public class LoginVo {

    private String userName;

    private String password;

}
