package com.lmk.orange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author caihl
 * @date 2020/4/7 10:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Course extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 作物id
     */
    private Integer cropId;

    /**
     * 种植技术
     */
    private Integer ptchId;

    /**
     * 教师id
     */
    private Long teacherId;

    /**
     * 作物品种
     */
    private Integer cvId;

    /**
     * 生长周期
     */
    private Integer gcId;

    /**
     * 宣传片地址
     */
    private String trailerUrl;

    /**
     * 主图地址
     */
    private String pictureUrl;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 介绍图片
     */
    private String introduceUrl;

    /**
     * 状态 状态 CP 审批，PS 审核通过，RJ 审核不通过，SL 课程下架
     */
    private String status;

    /**
     * 开课状态：0 未开课（未上传视频），1 已开课（未上传全部视频），2 已完结（已上传全部视频）
     */
    private Integer startStatus;

    /**
     * 开课时间
     */
    private LocalDateTime startTime;

    private LocalDateTime createTime;

    private String createBy;

    private LocalDateTime updateTime;

    private String updateBy;

    /**
     * 删除标记
     */
    private Integer deleteFlag;

    @ApiModelProperty("审核者")
    private String checkBy;

    @ApiModelProperty("备注")
    private String note;


}
