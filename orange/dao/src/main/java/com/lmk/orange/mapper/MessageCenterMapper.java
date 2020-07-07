package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.MessageCenter;
import com.lmk.orange.vo.MessageCenterVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @author WangShijun
 * @date 2020/5/12 10:31
 */
@Repository
public interface MessageCenterMapper extends BaseMapper<MessageCenter> {

    @Select(" SELECT mc.cer_id,mc.report_id,dr.name reportType,mc.id, mc.ce_id ,ce.describe,mc.course_id,c.`course_name`,mc" +
            ".course_class_id,cc" +
            ".`title`,mc.feedback_id,f.feedback_type,f" +
            ".`feedback_message`,mc" +
            ".student_id,s.`wechat_nikename`,mc.teacher_id,t.`teacher_name`,mc.notice_type,mc.create_time FROM message_center mc LEFT JOIN course c" +
            " ON c.`course_id` = mc.course_id LEFT JOIN teacher t ON t.`teacher_id` = mc.`teacher_id` LEFT JOIN course_class cc ON cc" +
            ".`course_class_id` = mc.`course_class_id` LEFT JOIN course_evaluate ce ON ce.`ce_id` = mc.`ce_id` LEFT JOIN feedback f ON f" +
            ".`feedback_id` = mc.`feedback_id` LEFT JOIN student s ON s.`student_id` = mc.`student_id` left join `course_evaluate_report` cer on " +
            "ce.ce_id = cer.ce_id left join dm_report dr on dr.id = cer.report_id " +
            "  ${ew.customSqlSegment} and " +
            "concat(ifnull(c.course_name,''),ifnull(t.teacher_name,''),ifnull(cc.title,''),ifnull(s.wechat_nikename,''),ifnull(f.feedback_message," +
            "'')," +
            "ifnull(ce.describe,'')) like " +
            "concat('%'," +
            "#{search},'%') " +
            "ORDER BY mc" +
            ".`notice_type` " +
            " ")
    Page<MessageCenterVo> getPage(Page page, @Param("search") String keyword, @Param("ew") QueryWrapper wrapper) ;





}
