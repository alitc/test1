package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/5/13 13:49
 */
@Data
@ApiModel("搜索历史对象")
public class SearchCourseHistoryVo {

    private Long id;

    private String name;

    private LocalDateTime createTime;

}
