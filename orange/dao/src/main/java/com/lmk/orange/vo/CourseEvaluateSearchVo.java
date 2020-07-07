package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangShijun
 * @date 2020/5/11 10:02
 */
@Data
@ApiModel("评论分页模糊查询参数DTO对象")
public class CourseEvaluateSearchVo {

    @ApiModelProperty("综合评分")
    private Double avgScore;

    @ApiModelProperty("评论时间（始）")
    private String startTime ;

    @ApiModelProperty("评论时间（止）")
    private String endTime;

    @ApiModelProperty("学生姓名（微信昵称）")
    private String wechatNikename;

    @ApiModelProperty("学生手机号")
    private String mobile;



}
