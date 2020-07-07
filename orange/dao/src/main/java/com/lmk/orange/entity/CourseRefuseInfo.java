package com.lmk.orange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/4/29 8:39
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CourseRefuseInfo extends Model {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer criId;

    private Integer courseId;
    /**
     * 驳回内容
     */
    private String content;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
