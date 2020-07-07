package com.lmk.orange.dto;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author caihl
 * @date 2020/4/24 15:33
 */
@Data
@ApiModel("保存课程信息")
public class CourseDto {

    @TableId(value = "course_id", type = IdType.AUTO)
    @ApiModelProperty("课程id，新建为空")
    private Integer courseId;

    private Long courseClassId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("课程价格")
    private BigDecimal price;

    @ApiModelProperty(value = "作物类型id",hidden = true)
    private Integer cropId=66;

    @ApiModelProperty("种植技术")
    private Integer ptchId;

    @ApiModelProperty("教师id")
    private Long teacherId;

    @ApiModelProperty("教师姓名")
    private String teacherName;

    @ApiModelProperty("教师头像")
    private String headUrl;

    @ApiModelProperty(value = "作物品种",hidden = true)
    private Integer cvId;

    @ApiModelProperty(value = "生长周期" )
    private Integer gcId;

    @ApiModelProperty(value = "宣传片地址 文件" )
    private MultipartFile trailerFile;

    @ApiModelProperty(value = "主图地址")
    private String pictureUrl;

    @ApiModelProperty(value = "主图文件" )
    private Object pictureFile;

    @ApiModelProperty(value = "介绍 内容" )
    private String introduce;

    @ApiModelProperty(value = "介绍图片" )
    private List<Object> introduceFile;

    @ApiModelProperty(value = "介绍地址")
    private String introduceUrl;

    @ApiModelProperty(value = "审核状态",hidden = true)
    private String status = "CP";

    @ApiModelProperty(value = "课程列表",required = false)
    private List<CourseClassDto> courseClassDtoList;

    @ApiModelProperty("课程介绍url")
    private List<String> introduceUrls;

    @ApiModelProperty("课程驳回原因")
    private String content;

    @ApiModelProperty("课程创建时间")
    private LocalDateTime createTime;

    public void setIntroduceUrl(String introduceUrl) {
        setIntroduceUrls(JSON.parseArray(introduceUrl, String.class));
        this.introduceUrl = introduceUrl;
    }

}
