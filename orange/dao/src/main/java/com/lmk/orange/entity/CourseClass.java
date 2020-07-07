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
 * 课节
 * </p>
 *
 * @author caihualong
 * @since 2020-04-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CourseClass extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "course_class_id", type = IdType.AUTO)
    private Integer courseClassId;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 节课排序
     */
    private Integer sort;

    /**
     * 标题
     */
    private String title;

    /**
     * 视频地址
     */
    private String videoUrl;

    /**
     * 时长 秒
     */
    private Double duration;

    /**
     * 状态：0 未上传视频，1 已上传视频
     */
    private Integer status;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 删除标记 0未作废，1 作废
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
