package com.lmk.orange.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/4/28 9:30
 */
@Data
@ApiModel("“编辑课程”分页列表")
public class CourseEditListVo {

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("种植技术")
    private Integer ptechId;

    @ApiModelProperty("种植技术名称")
    private String ptechName;

    @ApiModelProperty("教师id")
    private Integer teacherId;

    @ApiModelProperty("教师姓名")
    private String teacherName;

    @ApiModelProperty("作物品种")
    private Integer cvId;

    @ApiModelProperty("宣传片地址")
    private String trailerUrl;

    @ApiModelProperty("主图地址")
    private String pictureUrl;

    @ApiModelProperty("状态 CP 审批，PS 审核通过，RJ 审核不通过，SL 课程下架")
    private String status;

    @ApiModelProperty("开课状态：0 未开课，1 已开课")
    private Boolean startStatus;

    @ApiModelProperty("开课时间")
    private LocalDateTime startTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("编辑者")
    private String updateBy;

    @ApiModelProperty("审核者")
    private String checkBy;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("驳回原因")
    private String content;

    @ApiModelProperty("分享量")
    private Long shareNum;

    @ApiModelProperty("播放量")
    private Long playNum;

    @ApiModelProperty("收藏量")
    private Long collectNum;

    @ApiModelProperty("综合评分")
    private Double avgScore;





}
