package com.lmk.orange.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 消息
 * </p>
 *
 * @author caihualong
 * @since 2020-04-09
 */
@Data
@ApiModel("信息列表")
public class MessageListVo extends Model {

    @ApiModelProperty("消息id")
    private Integer messageId;

    @ApiModelProperty("消息类型：1开课提醒，2官方消息")
    private Boolean messageType;

    @ApiModelProperty("标题")
    private String messageTitle;

    @ApiModelProperty("详情")
    private String messageContent;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("是否已读")
    private boolean isRead;

}
