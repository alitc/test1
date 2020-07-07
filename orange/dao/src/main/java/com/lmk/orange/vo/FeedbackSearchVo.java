package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/5/11 9:11
 */
@Data
@ApiModel("反馈")
public class FeedbackSearchVo {

    @ApiModelProperty("意见反馈类型 1 程序错误，2 产品建议")
    private Integer feedbackType;

    @ApiModelProperty("学生姓名（微信昵称）")
    private String wechatNikename;

    @ApiModelProperty("学生手机号码")
    private Long mobile;

    @ApiModelProperty("反馈时间（始）")
    private LocalDateTime startTime;

    @ApiModelProperty("反馈时间（止）")
    private LocalDateTime endTime;
}
