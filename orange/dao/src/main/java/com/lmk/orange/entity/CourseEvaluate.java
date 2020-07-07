package com.lmk.orange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 课程评价
 * </p>
 *
 * @author caihualong
 * @since 2020-04-16
 */
@ApiModel
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CourseEvaluate extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ce_id", type = IdType.AUTO)
    private Integer ceId;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty(value = "学生id",hidden = true)
    private Long studentId;

    @ApiModelProperty("专业度 1-5")
    private int professionalism;

    @ApiModelProperty("表达能力 1-5")
    private int expression;

    @ApiModelProperty("生动 1-5")
    private int lively;

    @ApiModelProperty("实用 1-5")
    private int practical;

    @ApiModelProperty("价值 1-5")
    private int available;

    @ApiModelProperty("评论内容")
    @TableField("`describe`")
    private String describe;

    @ApiModelProperty(value = "官方回复",hidden = true)
    private String reply;

    @ApiModelProperty(value = "创建时间",hidden = true)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间",hidden = true)
    private LocalDateTime updateTime;


}
