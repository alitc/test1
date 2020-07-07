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
 * 意见反馈
 * </p>
 *
 * @author caihualong
 * @since 2020-04-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Feedback extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "feedback_id", type = IdType.AUTO)
    private Integer feedbackId;

    private Long studentId;

    /**
     * 意见反馈类型 1 程序错误，2 产品建议
     */
    private Integer feedbackType;

    private String feedbackMessage;

    /**
     * 反馈时间
     */
    private LocalDateTime feedbackTime;

    /**
     * 官方回复
     */
    private String feedbackReply;

    /**
     * 反馈来源，0 小程序，1 web
     */
    private Integer feedbackFrom;

    /**
     * 查看状态，0 未查看，1 已查看
     */
    private Integer note;


}
