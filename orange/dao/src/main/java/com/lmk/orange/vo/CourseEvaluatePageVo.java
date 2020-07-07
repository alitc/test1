package com.lmk.orange.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/5/11 9:47
 */
@Data
@ApiModel("评论分页对象")
public class CourseEvaluatePageVo {

    @ApiModelProperty("课程id")
    private Long courseId;

    @ApiModelProperty("评论id")
    private Long ceId;

    @ApiModelProperty("综合评分")
    private Double avgScore;

    @ApiModelProperty("评论内容")
    private String describe;

    @ApiModelProperty("官方回复")
    private String reply;

    @ApiModelProperty("评论时间")
    private LocalDateTime createTime;

    @ApiModelProperty("学生姓名（微信昵称）")
    private String wechatNikename;

    @ApiModelProperty("学生账户")
    private String account;

    @ApiModelProperty("学生头像")
    private String headUrl;

    @ApiModelProperty("手机号")
    private Long mobile;

    @ApiModelProperty("课程名")
    private String courseName;

    @ApiModelProperty("点赞数")
    private Long supportNum;

    @ApiModelProperty("备注,0：未回复，1：已回复，2：被举报，3：已回复 被举报")
    private Integer note;


}
