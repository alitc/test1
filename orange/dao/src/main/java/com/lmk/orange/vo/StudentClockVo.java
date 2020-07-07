package com.lmk.orange.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author caihl
 * @date 2020/4/15 17:36
 */
@Data
@ApiModel("打卡明细")
public class StudentClockVo {


    @ApiModelProperty("打卡所属年月")
    private String yearMoth;

    @ApiModelProperty("打卡日")
    private String day;

}
