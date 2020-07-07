package com.lmk.orange.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author caihl
 * @date 2020/4/16 10:56
 */
@Data
@ApiModel("课程")
public class CourseVo {

    @ApiModelProperty("课程id")
     private Integer courseId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("作物id")
    private Integer cropId;

    @ApiModelProperty("种植技术")
    private Integer ptchId;

    @ApiModelProperty("教师id")
    private Integer teacherId;

    @ApiModelProperty("作物品种")
    private Integer cvId;

    @ApiModelProperty("生长周期")
    private Integer gcId;

    @ApiModelProperty("宣传片地址")
    private String trailerUrl;

    @ApiModelProperty("主图地址")
    private String pictureUrl;

    @ApiModelProperty("介绍")
    private String introduce;

    @ApiModelProperty("状态 CP 审批，PS 审核通过，RJ 审核不通过，SL 课程下架")
    private String status;

    @ApiModelProperty("开课状态：0 未开课，1 已开课")
    private Boolean startStatus;

    @ApiModelProperty("开课时间")
    private LocalDateTime startTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("学员数量")
    private Long studentNumber;

    @ApiModelProperty("收藏数量")
    private Long collectNumber;

    @ApiModelProperty("播放数量")
    private Long playNum;

    @ApiModelProperty("分享数量")
    private Long shareNum;



}
