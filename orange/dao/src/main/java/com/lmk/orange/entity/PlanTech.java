package com.lmk.orange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 种植技术
 * </p>
 *
 * @author caihualong
 * @since 2020-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PlanTech  extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 种植技术id
     */
    @TableId(value = "ptech_id", type = IdType.AUTO)
    private Integer ptechId;

    /**
     * 技术名称
     */
    private String ptechName;

    /**
     * 记录作废标记 0 未作废，1 作废
     */
    private Boolean deleteFlag;


}
