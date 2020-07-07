package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author WangShijun
 * @date 2020/5/5 15:39
 */
@Data
@ApiModel("用户地域排名（市）")
public class CityRankingVo {

    private String city;

    private Long personNum;

    private Double proportion;
}
