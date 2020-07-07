package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmk.orange.entity.PlanTech;
import com.lmk.orange.vo.PlanTechVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 种植技术 Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-07
 */
@Repository
public interface PlanTechMapper extends BaseMapper<PlanTech> {

    @Select("select ptech_id,ptech_name from plan_tech where delete_flag = 0 ")
    List<PlanTechVo> listVo();

}
