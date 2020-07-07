package com.lmk.orange.vo;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WangShijun
 * @date 2020/4/28 15:44
 */
@Data
@ApiModel("课节详情")
public class CourseClassVo {

    @ApiModelProperty("课节主键id")
    @TableId(value = "course_class_id", type = IdType.AUTO)
    private Integer courseClassId;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("课程主图地址")
    private String pictureUrl;

    @ApiModelProperty("种植技术id")
    private Integer ptchId;

    @ApiModelProperty("讲师id")
    private Long teacherId;

    @ApiModelProperty("课程介绍详情")
    private String introduce;

    @ApiModelProperty("课程介绍url")
    private String introduceUrl;

    @ApiModelProperty("课节顺序")
    private Integer sort;

    @ApiModelProperty("课节标题")
    private String title;

    @ApiModelProperty("课节视频地址")
    private String videoUrl;

    @ApiModelProperty("课节时长")
    private Double duration;

    @ApiModelProperty("状态：0 未上传视频，1 已上传视频")
    private Integer status;

    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty("课程介绍url")
    private List<String> introduceUrls;

    public void setIntroduceUrl(String introduceUrl) {
        setIntroduceUrls(JSON.parseArray(introduceUrl, String.class));
        this.introduceUrl = introduceUrl;
    }
}
