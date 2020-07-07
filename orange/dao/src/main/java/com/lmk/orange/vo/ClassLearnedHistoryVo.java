package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/4/30 13:50
 */
@Data
@ApiModel("课节历史详情")
public class ClassLearnedHistoryVo {
    private Long courseId;

    private String title;

    private String pictureUrl;

    @ApiModelProperty("观看时间百分比")
    private Double learned;

    @ApiModelProperty("最后观看时间")
    private LocalDateTime endTime;

    private String courseName;

    private Long teacherId;

    private String teacherName;

    private String headUrl;

}
