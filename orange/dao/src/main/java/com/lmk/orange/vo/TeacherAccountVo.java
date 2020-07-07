package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangShijun
 * @date 2020/4/27 16:51
 */
@Data
@ApiModel("教师个人账户")
public class TeacherAccountVo {
    @ApiModelProperty("教师Id")
    private Integer teacherId;

    @ApiModelProperty("账户名")
    private Long account;

    @ApiModelProperty("账户密码")
    private String password;

}
