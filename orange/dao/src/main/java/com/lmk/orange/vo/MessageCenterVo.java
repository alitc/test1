package com.lmk.orange.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/5/13 11:29
 */
@Data
@ApiModel("通知中心信息")
public class MessageCenterVo {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("评论id")
    private Long ceId;

    @ApiModelProperty("评论内容")
    private String describe;

    @ApiModelProperty("课程id")
    private Long courseId;

    @ApiModelProperty("课程名")
    private String courseName;

    @ApiModelProperty("课节id")
    private Long courseClassId;

    @ApiModelProperty("课节标题")
    private String title;

    @ApiModelProperty("意见反馈id")
    private Long feedbackId;

    @ApiModelProperty("意见反馈类型id")
    private Integer feedbackType;

    @ApiModelProperty("意见反馈内容")
    private String feedbackMessage;

    @ApiModelProperty("学生id")
    private Long studentId;

    @ApiModelProperty("学生微信昵称")
    private String wechatNikename;

    @ApiModelProperty("教师id")
    private Long teacherId;

    @ApiModelProperty("教师名称")
    private String teacherName;

    @ApiModelProperty("通知类型，1：开课没视频,2：课程被驳回，3：评论被举报，4：意见反馈，5：收藏课程，6：分享课程，7：预约课程，8：关注讲师")
    private Integer noticeType;

    @ApiModelProperty("通知紧急程度")
    private Integer noticeDegree;

    @ApiModelProperty("通知创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("举报id")
    private Long cerId;

    @ApiModelProperty("举报类型id")
    private Long reportId;

    @ApiModelProperty("举报类型")
    private String reportType;

    @ApiModelProperty("通知内容")
    private String content;

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
        switch (noticeType){
            case 1 :
            case 2 : this.noticeDegree = 1;break;
            case 3 :
            case 4 : this.noticeDegree = 2;break;
            case 5 :
            case 6 :
            case 7 :
            case 8 : this.noticeDegree = 3;break;
        }

    }

}
