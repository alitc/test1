package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/5/14 13:48
 */
@Data
@ApiModel("评价详情")
public class CourseEvaluateInfoVo {

    private Long ceId;

    private Long studentId;

    private String headUrl;

    private String wechatNikename;

    private LocalDateTime createTime;

    private Double avgScore;

    private String describe;

    private String reply;

    private Long courseId;
}
