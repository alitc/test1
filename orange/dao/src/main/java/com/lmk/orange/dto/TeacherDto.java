package com.lmk.orange.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author caihl
 * @date 2020/4/23 10:52
 */
@Data
@ApiModel("保存教师信息")
public class TeacherDto {

    @ApiModelProperty("教师id，新建时为空")
    private Long teacherId;

    @ApiModelProperty("教师名称")
    private String teacherName;

    @ApiModelProperty("手机号")
    private Long mobile;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("头像文件")
    private Object headFile;

    @ApiModelProperty("介绍")
    private String introduce;

    @ApiModelProperty("介绍图片")
    private MultipartFile introduceFile;

    @ApiModelProperty("专长(每项之间用分号分隔)")
    private String expert;

    @ApiModelProperty("性别 1男性，2女性")
    private Integer sex;

    @ApiModelProperty("讲师资质")
    private String qualification;

}
