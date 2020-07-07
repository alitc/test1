package com.lmk.orange.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author caihl
 * @date 2020/4/14 17:16
 */
@Data
@ApiModel("微信课程列表")
public class WechatCourseListVo {

    @ApiModelProperty("最新更新课程")
    private List<CourseListVo> newCourseTop;


    @ApiModelProperty("精选好课")
    private IPage<CourseListVo> courseList;




}
