package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author caihl
 * @date 2020/4/7 11:37
 */
@Data
@ApiModel("种植技术")
public class PlanTechVo {


    @ApiModelProperty("种植技术id")
    private Integer ptechId;

    @ApiModelProperty("技术名称")
    private String ptechName;

}
