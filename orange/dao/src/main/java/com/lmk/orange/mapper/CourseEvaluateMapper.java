package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.CourseEvaluate;
import com.lmk.orange.vo.CourseEvaluateInfoVo;
import com.lmk.orange.vo.CourseEvaluateListVo;
import com.lmk.orange.vo.CourseEvaluatePageVo;
import com.lmk.orange.vo.StudentEvaluateListVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程评价 Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-16
 */
@Repository
public interface CourseEvaluateMapper extends BaseMapper<CourseEvaluate> {

    @Select("select t.ce_id,t.course_id,t.student_id," +
            "       s.wechat_nikename student_name," +
            "       s.head_url student_head_url," +
            "       t.describe,reply," +
            "       t.create_time," +
            "       t.update_time," +
            "       ROUND((professionalism+expression+lively+practical+available)/5,1) composite_score, " +
            "       (select count(1) from course_evaluate_support ces where ces.ce_id = t.ce_id ) support_num," +
            "       (select (case when count(1)>0 then 1 else 0 end) " +
            "          from course_evaluate_support ces where ces.ce_id = t.ce_id and ces.student_id =#{studentId} and #{studentId} is not null" +
            "        )is_support " +
            "  from course_evaluate t ,student s " +
            " where t.student_id=s.student_id and course_id=#{courseId}")
    IPage<CourseEvaluateListVo> listEvaluate(Page page, @Param("courseId") Integer courseId, @Param("studentId") Long studentId);

    @Select("select  AVG(ROUND((professionalism+expression+lively+practical+available)/5,1)) score from course_evaluate t where t.course_id = #{courseId}")
    Double getCourseScore(@Param("courseId") Integer courseId);

    @Select(" select" +
            "   ce_id, " +
            "   ROUND((professionalism+expression+lively+practical+available)/5,2) composite_score,\n" +
            "   s.wechat_nikename student_name, \n" +
            "   s.head_url student_head_url,    \n" +
            "   ce.describe,   \n" +
            "   ce.reply,      \n" +
            "   c.course_id," +
            "   c.course_name, \n" +
            "   c.picture_url, \n" +
            "   c.start_time,  \n" +
            "   t.teacher_name,\n" +
            "   t.head_url teacher_head_img," +
            "   ce.update_time   \n" +
            " from course_evaluate ce,student s,teacher t,course c \n" +
            " where ce.course_id=c.course_id  \n" +
            "  and ce.student_id=s.student_id \n" +
            "  and c.teacher_id=t.teacher_id " +
            "  and s.student_id=#{studentId} ")
    IPage<StudentEvaluateListVo> studentEvaluateList(Page page, Long studentId);

    @Delete("delete from course_evaluate where ce_id = #{ce_id} and student_id = #{student_id}")
    Integer delEvaluate(@Param("student_id") Long studentId, @Param("ce_id") Long ceId);

    @Select("SELECT ce.ce_id ,ce.course_id,ce.student_id,ce.avgScore,ce.describe,ce.reply,CASE WHEN ce.reply IS NOT NULL AND (SELECT COUNT(1) FROM course_evaluate_report cer WHERE ce.ce_id = cer.ce_id ) > 0 THEN 3 WHEN (SELECT COUNT(1) FROM course_evaluate_report cer WHERE ce.ce_id = cer.ce_id ) > 0 THEN 2 WHEN ce.reply IS NOT NULL THEN 1 ELSE 0 END note,s.wechat_nikename ,s.account,s.head_url,s.mobile,c.course_name,ce.create_time,IFNULL(ces.supportNum,0) supportNum \n" +
            "FROM (SELECT ce_id,course_id,student_id,(professionalism + expression + lively + practical + available)/5 avgScore,`describe`,reply,create_time FROM course_evaluate) ce \n" +
            "LEFT JOIN student s ON s.student_id = ce.student_id \n" +
            "LEFT JOIN (SELECT ces.ce_id ,COUNT(1) supportNum FROM course_evaluate_support ces GROUP BY ces.ce_id) ces ON ces.ce_id = ce.ce_id \n" +
            "LEFT JOIN course c ON c.course_id = ce.course_id\n" +
            " ${ew.customSqlSegment}")
    IPage<CourseEvaluatePageVo> getPage(Page page, @Param("ew") QueryWrapper wrapper);

    @Delete("delete from course_evaluate where ce_id = #{ce_id}")
    Integer delEvaluateList(@Param("ce_id") Long ceId);

    @Update("update course_evaluate set reply = #{reply} where ce_id = #{ce_id}")
    Integer setReply(@Param("ce_id") Long ceId, @Param("reply") String reply);

    @Select("SELECT ce.ce_id,ce.course_id,ce.student_id,s.wechat_nikename,s.head_url,ce.create_time,(ce.professionalism + ce.expression + ce.lively + ce.practical + ce.available)/5 avgScore ,ce.describe ,ce.reply FROM course_evaluate ce LEFT JOIN student s ON s.student_id = ce.student_id WHERE ce.ce_id = #{ce_id}")
    CourseEvaluateInfoVo getInfo(@Param("ce_id") Long ceId);
}
