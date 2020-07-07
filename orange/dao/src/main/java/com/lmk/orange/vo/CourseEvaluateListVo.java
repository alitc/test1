package com.lmk.orange.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 课程评价
 * </p>
 *
 * @author caihualong
 * @since 2020-04-16
 */
@Data
@ApiModel
public class CourseEvaluateListVo extends Model {


    @ApiModelProperty("评论id")
    private Integer ceId;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("学员id")
    private Integer studentId;

    @ApiModelProperty("学员名称")
    private String studentName;

    @ApiModelProperty("学员头像")
    private String studentHeadUrl;

    @ApiModelProperty("综合评分")
    private double compositeScore;

    @ApiModelProperty("评论内容")
    private String describe;

    @ApiModelProperty("官方回复")
    private String reply;

    @ApiModelProperty("点赞数")
    private Integer supportNum;

    @ApiModelProperty("是否点赞")
    private Boolean isSupport;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;



}
