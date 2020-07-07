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
 * 学生课节学习进度
 * </p>
 *
 * @author caihualong
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class StudentClassLearned  extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Long studentId;

    /**
     * 课节id
     */
    private Integer courseClassId;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    /**
     * 已学时长 秒钟
     */
    private Long learnedTime;

    /**
     * 完成标记 1完成 0未完成
     */
    private Boolean finish;


}
