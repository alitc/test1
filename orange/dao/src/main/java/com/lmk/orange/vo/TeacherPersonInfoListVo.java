package com.lmk.orange.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangShijun
 * @date 2020/4/27 13:29
 */
@Data
@ApiModel("教师个人信息列表")
public class TeacherPersonInfoListVo {

    @ApiModelProperty("教师id")
    private Long teacherId;

    @ApiModelProperty("教师名称")
    private String teacherName;

    @ApiModelProperty("课程数")
    private Integer courseNum;

    @ApiModelProperty("综合评分")
    private Double avgScore;

    @ApiModelProperty("播放量")
    private Long playNum;

    @ApiModelProperty("分享量")
    private Long shareNum;

    @ApiModelProperty("收藏量")
    private Long collectNum;

    }

