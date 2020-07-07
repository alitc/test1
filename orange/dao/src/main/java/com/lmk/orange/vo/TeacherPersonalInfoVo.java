package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangShijun
 * @date 2020/4/27 14:19
 */
@Data
@ApiModel("教师个人信息查看")
public class TeacherPersonalInfoVo {
    @ApiModelProperty("教师id")
    private Long teacherId;

    @ApiModelProperty("教师名称")
    private String teacherName;

    @ApiModelProperty("手机号")
    private Long mobile;

    @ApiModelProperty("权限")
    private Integer rule;
}
