package com.lmk.orange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class StudentClock extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "clock_id", type = IdType.AUTO)
    private Integer clockId;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 月份 格式YYYY-MM
     */
    @TableField("yearMoth")
    private String yearMoth;

    /**
     * 打卡日
     */
    private String day;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
