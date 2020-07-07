package com.lmk.orange.vo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author caihl
 * @date 2020/4/16 11:10
 */
@Data
@ApiModel("课程详情")
public class CourseCollegeDetailVo {

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("是否已收藏课程")
    private boolean courseIsCollect;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("宣传片地址")
    private String trailerUrl;

    @ApiModelProperty("主图地址")
    private String pictureUrl;

    @ApiModelProperty("课程介绍")
    private String introduce;

    @ApiModelProperty("课程介绍图片")
    private String introduceUrl;

    @ApiModelProperty("开课状态：0 未开课（未上传视频），1 已开课（未上传全部视频），2 已完结（已上传全部视频）")
    private Integer startStatus;

    @ApiModelProperty("开课时间")
    private LocalDateTime startTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("学员数量")
    private Long studentNumber;

    @ApiModelProperty("收藏数量")
    private Long collectNumber;

    @ApiModelProperty("课程大纲")
    private Map<Integer,Object> allClass;

    @ApiModelProperty("教师id")
    private Long teacherId;

    @ApiModelProperty("教师名称")
    private String teacherName;

    @ApiModelProperty("教师头像地址")
    private String headUrl;

    @ApiModelProperty("导师介绍")
    private String teacherIntroduce;

    @ApiModelProperty("导师介绍图片")
    private String teacherIntroduceUrl;

    @ApiModelProperty("导师擅长领域")
    private String teacherExpert;

    @ApiModelProperty("教师是否已关注")
    private boolean teacherIsFocus;

    @ApiModelProperty("上次播放课节id")
    private Integer lastClassId;

    @ApiModelProperty("上次播放课节秒数")
    private Long lastClassSecond;

    @ApiModelProperty("评价分数")
    private Double score;

    @ApiModelProperty("课程介绍url")
    private List<String> introduceUrls;

    public void setIntroduceUrl(String introduceUrl) {
        setIntroduceUrls(JSON.parseArray(introduceUrl, String.class));
        this.introduceUrl = introduceUrl;
    }

}
