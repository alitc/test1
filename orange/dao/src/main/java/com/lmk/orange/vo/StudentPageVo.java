package com.lmk.orange.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangShijun
 * @date 2020/5/7 14:31
 */
@Data
@ApiModel("普通用户分页对象")
public class StudentPageVo {

    @ApiModelProperty("学生id")
    private Long studentId;

    @ApiModelProperty("学生账号")
    private String account;

    @ApiModelProperty("微信昵称")
    private String wechatNikename;

    @ApiModelProperty("学生头像")
    private String headUrl;

    @ApiModelProperty("手机号码")
    private Long mobile;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("播放数")
    private Long playNum;

    @ApiModelProperty("关注数")
    private Long focusNum;

    @ApiModelProperty("收藏数")
    private Long collectNum;

    @ApiModelProperty("分享数")
    private Long shareNum;

    @ApiModelProperty("评价数")
    private Long aveluateNum;

    @ApiModelProperty("评论权限")
    private Integer canEvaluate;

    @ApiModelProperty("举报权限")
    private Integer canReport;
}
