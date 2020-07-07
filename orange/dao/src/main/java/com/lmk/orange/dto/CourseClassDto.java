package com.lmk.orange.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author caihl
 * @date 2020/4/24 14:26
 */
@Data
@ApiModel("保存课节信息")
public class CourseClassDto {

    @ApiModelProperty("课节id 新建时为空")
    private Integer courseClassId;

    @ApiModelProperty("课程id 新建时为空")
    private Integer courseId;

    @ApiModelProperty("节课排序")
    private Integer sort;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("视频文件")
    private Object videoFile;

    @ApiModelProperty("视频文件地址")
    private String videoUrl;

    @ApiModelProperty("时长 单位秒")
    private Double duration;

    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;


}
