package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author caihl
 * @date 2020/4/15 17:33
 */
@Data
@ApiModel("学生打卡")
public class StudentClockInfoVo {

    @ApiModelProperty("打卡总数")
    private Integer clockCount;

    @ApiModelProperty("打卡月份")
    private String yearMoth;

    @ApiModelProperty("打卡记录")
    private List<String> clockDays;

}
