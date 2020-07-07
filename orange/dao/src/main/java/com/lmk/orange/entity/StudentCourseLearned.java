package com.lmk.orange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author caihualong
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class StudentCourseLearned  extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 最近学习课节id
     */
    private Integer learnClassId;

    /**
     * 最近学习课节秒数
     */
    private Long learnClassSecond ;

    /**
     * 课程已学时长
     */
    private Long learnDuration	 ;


    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 状态：0 未开始 ，1 正在学习，2 已完成
     */
    private Integer status;

}
