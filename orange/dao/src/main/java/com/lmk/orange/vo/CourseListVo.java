package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author caihl
 * @date 2020/4/7 14:13
 */
@Data
@ApiModel("课程列表")
public class CourseListVo {

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("种植技术")
    private Integer ptchId;

    @ApiModelProperty("教师名称")
    private String teacherName;

    @ApiModelProperty("教师头像地址")
    private String headUrl;

    @ApiModelProperty("主图地址")
    private String pictureUrl;

    @ApiModelProperty("开课状态：0 未开课（未上传视频），1 已开课（未上传全部视频），2 已完结（已上传全部视频）")
    private Boolean startStatus;

    @ApiModelProperty("开课时间")
    private LocalDateTime startTime;

    @ApiModelProperty("开课时间")
    private Long startTimeStamp;

    @ApiModelProperty("学员数量")
    private Long studentNumber;

    @ApiModelProperty("已加入")
    private boolean isSubscribe;

    @ApiModelProperty("已学时长 单位秒")
    private Long learnDuration;

    @ApiModelProperty("课程总时长 单位秒")
    private Long totalDuration;

    @ApiModelProperty("收藏时间")
    private LocalDateTime createTime;


}
