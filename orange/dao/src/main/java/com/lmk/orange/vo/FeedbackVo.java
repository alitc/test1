package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/5/8 16:15
 */
@Data
@ApiModel("意见反馈")
public class FeedbackVo {

    private Long feedbackId;

    private Long studentId;

    @ApiModelProperty("姓名（微信昵称）")
    private String wechatNikename;

    @ApiModelProperty("头像")
    private String headUrl;

    @ApiModelProperty("学生手机号")
    private Long mobile;

    @ApiModelProperty("性别（0：未知，1：男，2：女）")
    private Integer sex;

    @ApiModelProperty("意见反馈类型 1 程序错误，2 产品建议")
    private Integer feedbackType;

    @ApiModelProperty("意见反馈内容")
    private String feedbackMessage;

    @ApiModelProperty("官方回复内容")
    private String feedbackReply;

    @ApiModelProperty("反馈图片")
    private String feedbackImgUrl;

    @ApiModelProperty("反馈时间")
    private LocalDateTime feedbackTime;

    @ApiModelProperty("备注，0：未查看，1：已查看，2：已回复")
    private Integer note;

}
