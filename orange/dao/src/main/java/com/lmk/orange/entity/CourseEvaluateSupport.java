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
public class CourseEvaluateSupport extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 点赞id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private Long studentId;

    /**
     * 评论id
     */
    private Integer ceId;

    private LocalDateTime createTime;


}
