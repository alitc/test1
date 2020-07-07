package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author caihl
 * @date 2020/4/22 14:58
 */
@Data
@ApiModel("学员评价列表信息")
public class StudentEvaluateListVo {

    @ApiModelProperty("评价id")
    private  Integer ceId;

    @ApiModelProperty("学员名称")
    private String studentName;

    @ApiModelProperty("学员头像")
    private String studentHeadUrl;

    @ApiModelProperty("综合评分")
    private double compositeScore;

    @ApiModelProperty("评论内容")
    private String describe;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("主图地址")
    private String pictureUrl;

    @ApiModelProperty("开课时间")
    private LocalDateTime startTime;

    @ApiModelProperty("教师名称")
    private String teacherName;

    @ApiModelProperty("教师头像地址")
    private String teacherHeadImg;

    @ApiModelProperty("官方回复")
    private String reply;

    @ApiModelProperty("回复时间")
    private LocalDateTime updateTime;

}
