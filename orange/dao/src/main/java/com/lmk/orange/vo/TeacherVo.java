package com.lmk.orange.vo;

import com.lmk.orange.entity.Teacher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author caihl
 * @date 2020/4/23 11:32
 */
@Data
@ApiModel("教师")
public class TeacherVo {

    @ApiModelProperty("教师id")
    private Long teacherId;

    @ApiModelProperty("教师名称")
    private String teacherName;

    @ApiModelProperty("账号 手机号")
    private String account;

    @ApiModelProperty("手机号")
    private Long mobile;

    @ApiModelProperty("头像地址")
    private String headUrl;

    @ApiModelProperty("介绍")
    private String introduce;

    @ApiModelProperty("介绍图片")
    private String introduceUrl;

    @ApiModelProperty("专长")
    private String expert;

    @ApiModelProperty("性别 1男性，2女性")
    private Integer sex;

    @ApiModelProperty("讲师资质")
    private String qualification;

    @ApiModelProperty("关注量")
    private String focusNum;

    @ApiModelProperty("入驻时间")
    private LocalDateTime createTime;

    public TeacherVo(){
        super();
    }

    public TeacherVo(Teacher teacher){
        this.setMobile(teacher.getMobile());
        this.setAccount(teacher.getAccount());
        this.setSex(teacher.getSex());
        this.setIntroduce(teacher.getIntroduce());
        this.setHeadUrl(teacher.getHeadUrl());
        this.setExpert(teacher.getExpert());
        this.setTeacherName(teacher.getTeacherName());
        this.setTeacherId(teacher.getTeacherId());
        this.setQualification(teacher.getQualification());
        this.setCreateTime(teacher.getCreateTime());
    }

}
