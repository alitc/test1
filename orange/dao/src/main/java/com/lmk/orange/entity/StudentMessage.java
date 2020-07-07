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
 * 消息
 * </p>
 *
 * @author caihualong
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class StudentMessage  extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 消息id
     */
    @TableId(value = "message_id", type = IdType.AUTO)
    private Integer messageId;

    /**
     * 消息类型：1开课提醒，2官方消息
     */
    private Integer messageType;

    /**
     * 标题
     */
    private String messageTitle;

    /**
     * 详情
     */
    private String messageContent;

    /**
     * 指定用户查看的信息，空 代表传递全部用户
     */
    private Integer studentId;

    private LocalDateTime createTime;


}
