package com.lmk.orange.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author WangShijun
 * @date 2020/5/5 15:24
 */
@Data
@ApiModel("用户地域排名（省）")
public class ProvinceRankingVo {

    private String province;

    private Long personNum;

    private Double proportion;

}
