package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author WangShijun
 * @date 2020/5/8 10:15
 */
@Data
@ApiModel("课程搜索对象")
public class CourseSearchVo {

    private Long  ptchId;

    private String status;

    private Integer startStatus;

    private String search;

    private String startTime;

    private String endTime;

    private String orderBy;
}
