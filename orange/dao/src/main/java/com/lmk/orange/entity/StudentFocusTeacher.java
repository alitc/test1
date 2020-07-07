package com.lmk.orange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 学员关注教师
 * </p>
 *
 * @author caihualong
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("student_focus_teacher")
public class StudentFocusTeacher extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Long studentId;

    private Long teacherId;

    private String teacherName;

    private String headUrl;

    private LocalDateTime createTime;

    @ApiModelProperty("讲师专长")
    private String expert;

    @ApiModelProperty("讲师介绍")
    private String introduce;

    @ApiModelProperty("讲师资质")
    private String qualification;


}
