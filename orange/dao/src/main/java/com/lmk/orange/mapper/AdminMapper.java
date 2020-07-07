package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.Admin;
import com.lmk.orange.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 管理员 Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-07
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

    @Select("select * from admin where admin_id=#{userId} and delete_flag =0 ")
    Admin getByUserId(@Param("userId") Long userId);

    @Select("select admin_id,rule from admin where account = #{account} and password = #{password} and delete_flag = 0")
    Admin isLogin(@Param("account") String account, @Param("password") String password);

    @Select("select teacher_id,rule from teacher where account = #{account} and password = #{password} and delete_flag = 0")
    Teacher isLoginTeacher(@Param("account") String account, @Param("password") String password);

    @Select("SELECT a.`admin_id`,a.`account` ,a.`mobile`,a.`wechat_nikename`,a.`rule` FROM admin a  " +
            " ${ew.customSqlSegment} ")
    IPage<Admin> getList(Page page, @Param("ew") QueryWrapper wrapper);

    @Update("update admin set password = #{password} where admin_id = #{admin_id}")
    Integer replaceSuperPassword(@Param("admin_id") Long adminId, @Param("password") String password);

    @Update("update admin set delete_flag = 1 where admin_id = #{admin_id}")
    Integer delUser(@Param("admin_id") Long adminId);

    @Update("update admin set password = #{password} where admin_id = #{admin_id} and rule != 1")
    Integer replacePassword(@Param("admin_id") Long adminId, @Param("password") String password);

    @Update("update admin set password = #{password} where mobile = #{mobile} or account = #{mobile}" )
    Integer changePasswordById(@Param("mobile") Long mobile, @Param("password") String password);




}
