package com.lmk.orange.vo;

import com.lmk.orange.entity.StudentMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author caihl
 * @date 2020/4/14 17:55
 */
@Data
@ApiModel("课程列表")
public class WechatHomeVo {

    @ApiModelProperty("种植技术列表")
    List<PlanTechVo> planTechVos;

    @ApiModelProperty("首页推荐")
    List<CourseListVo> qualityCourse;

    @ApiModelProperty("消息列表")
    List<StudentMessage> messageList;

}
