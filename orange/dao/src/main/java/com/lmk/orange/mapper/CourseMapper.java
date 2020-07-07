package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.Course;
import com.lmk.orange.vo.CourseEditListVo;
import com.lmk.orange.vo.CourseListVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author caihl
 * @date 2020/4/7 10:37
 */
@Repository
public interface CourseMapper  extends BaseMapper<Course> {

    @Select("<script>" +
            " select " +
            "  c.course_id," +
            "  c.course_name," +
            "  c.price," +
            "  c.picture_url," +
            "  c.start_time start_time," +
            "  c.start_status," +
            "  c.ptch_id," +
            "  t.teacher_name,t.head_url headUrl, \n" +
            "  (select count(1) from student_course_learned scl where scl.course_id=c.course_id) studentNumber," +
            "  (select (case when count(1)>0 then 1 else 0 end) cc from student_subscribe_course scl where scl.course_id=c.course_id and scl.student_id =#{studentId}  and #{studentId} is not null ) isSubscribe \n" +
            "from course c left join teacher t on c.teacher_id=t.teacher_id\n" +
            " where c.status='PS'" +
            "  <if test='ptchId!=null and ptchId!=0' >" +
            "    and c.ptch_id = #{ptchId} " +
            "  </if>" +
            "  and c.delete_flag =0 " +
            "order by studentNumber desc" +
            "</script> ")
    IPage<CourseListVo> listCourseByPtch(Page page, @Param("ptchId") Integer ptchId, @Param("studentId") Long studentId);

    @Select("<script>" +
            " select  " +
            "  c.course_id," +
            "  c.course_name," +
            "  c.price," +
            "  c.picture_url," +
            "  c.start_time start_time," +
            "  c.start_status," +
            "  c.ptch_id," +
            "  t.teacher_name,t.head_url headUrl, \n" +
            "  (select count(1) from student_course_learned scl where scl.course_id=c.course_id) studentNumber," +
            "  (select (case when count(1)>0 then 1 else 0 end) cc from student_subscribe_course scl where scl.course_id=c.course_id and scl.student_id =#{studentId}  and #{studentId} is not null ) isSubscribe \n" +
            " from course c left join teacher t on c.teacher_id=t.teacher_id\n" +
            " where c.status='PS'" +
            "   <if test='ptchId!=null and ptchId!=0' >" +
            "     and c.ptch_id = #{ptchId} " +
            "   </if>" +
            "  and c.delete_flag =0 " +
            " order by c.update_time desc" +
            " limit 0,3 " +
            "</script> ")
    List<CourseListVo> listCourseByPtchNew(@Param("ptchId") Integer ptchId, @Param("studentId") Long studentId);

    @Select( " select" +
            "  c.course_id," +
            "  c.course_name," +
            "  c.price," +
            "  c.picture_url," +
            "  c.start_time start_time," +
            "  c.start_status,c.ptch_id," +
            "  t.teacher_name," +
            "  t.head_url , \n" +
            "  (select count(1) from student_course_learned scl where scl.course_id=c.course_id) studentNumber\n" +
            " from course c left join teacher t on c.teacher_id=t.teacher_id,course_quality cq\n" +
            " where c.status='PS'   \n" +
            "  and c.delete_flag =0 " +
            "  and c.course_id =cq.course_id")
    List<CourseListVo> listQualityCourse();

    @Select(" select " +
            "  c.course_id," +
            "  c.course_name," +
            "  c.price," +
            "  c.picture_url," +
            "  c.start_time start_time," +
            "  c.start_status," +
            "  c.ptch_id," +
            "  t.teacher_name,t.head_url headUrl, \n" +
            "  (select count(1) from student_course_learned scl where scl.course_id=c.course_id) studentNumber," +
            "  (select (case when count(1)>0 then 1 else 0 end) cc from student_subscribe_course scl where scl.course_id=c.course_id and scl.student_id =#{studentId}  and #{studentId} is not null ) isSubscribe \n" +
            "from course c left join teacher t on c.teacher_id=t.teacher_id left join plan_tech pt on c.ptch_id =pt.ptech_id\n" +
            " where c.status='PS'   \n" +
            "  and c.delete_flag =0 " +
            "  and (c.course_name like #{name} or ptech_name like #{name} or ptech_name is null )\n" +
            "order by c.update_time desc")
    IPage<CourseListVo> serchCourse(Page page, @Param("name") String name);

    @Select("select (case when count(1)>0 then 1 else 0 end) cc " +
            "  from student_course_collect " +
            " where student_id =#{studentId} and course_id =#{courseId} ")
    boolean isCellectCourse(@Param("studentId") Long studentId, @Param("courseId") Integer courseId);

    @Select(" select " +
            "  cc.course_class_id," +
            "  cc.title," +
            "  (case when cc.start_time<=now() and c.start_time<=now() then cc.video_url else null end) video_url," +
            "  cc.duration," +
            "  cc.start_time" +
            " from course_class cc,course c" +
            " where cc.course_id=c.course_id " +
            "   and cc.course_id = #{courseId} " +
            "   and cc.delete_flag=0 "+
            " order by cc.sort ")
    List<Map> listAllClass(@Param("courseId") Integer courseId);

    @Select("select count(1) from student_course_collect where course_id = #{courseId}")
    Long cellectNumber(@Param("courseId") Integer courseId);

    @Select("select count(1) from student_course_learned where course_id = #{courseId} ")
    Long studentNumber(@Param("courseId") Integer courseId);

    @Select("<script> SELECT c.course_id,IFNULL(scs.shareNum,0) shareNum,IFNULL(scc.collectNum,0) collectNum,c" +
            ".course_name,IFNULL(ce.score,0) avgScore,c.`picture_url`,IFNULL(ce2.playNum,0) playNum,t.teacher_id,t" +
            ".teacher_name,c.start_time,p.ptech_id,p.ptech_name,c.status,c.start_status,c.update_by,c.check_by," +
            "cri.content content "  +
            "FROM \n" +
            "course c \n" +
            "LEFT JOIN \n" +
            "teacher t \n" +
            "ON \n" +
            "t.`teacher_id`=c.`teacher_id` AND c.delete_flag = 0 \n" +
            "LEFT JOIN \n" +
            "plan_tech p \n" +
            "ON \n" +
            "c.ptch_id = p.ptech_id \n" +
            "LEFT JOIN \n" +
            "(SELECT ce.course_id, IFNULL(((SUM(ce.professionalism)+SUM(ce.expression)+SUM(ce.lively)+SUM(ce.`practical`)+SUM(ce.`available`))" +
            "/5/COUNT(1)),0) score FROM course_evaluate ce GROUP BY ce.`course_id`)ce\n" +
            "ON\n" +
            "ce.course_id = c.`course_id`\n" +
            "LEFT JOIN \n" +
            "(SELECT cc.`course_id`,IFNULL(COUNT(1),0) playNum FROM student_class_learned scl LEFT JOIN course_class cc  ON cc.course_class_id = scl.course_class_id GROUP BY cc.`course_id` )ce2\n" +
            "ON\n" +
            "ce2.course_id = c.`course_id`\n" +
            "LEFT JOIN \n" +
            "(SELECT scc.`course_id`,IFNULL(COUNT(1),0) collectNum FROM student_course_collect scc GROUP BY scc.`course_id`)scc\n" +
            "ON\n" +
            "scc.course_id = c.`course_id`\n" +
            "LEFT JOIN \n" +
            "(SELECT course_id ,IFNULL(COUNT(1),0) shareNum FROM student_course_share scs GROUP BY course_id)scs\n" +
            "ON\n" +
            "scs.course_id = c.`course_id`" +
            "left join" +
            "`course_refuse_info` cri " +
            "on " +
            "cri.course_id = c.course_id  ${ew.customSqlSegment} and concat(c.course_name,t.teacher_name) like #{search}\n" +
            "ORDER BY ${orderBy} </script>")
    IPage<CourseEditListVo> editList(IPage iPage, @Param("ew") QueryWrapper wrapper, @Param("orderBy") String orderBy, @Param("search") String search);

    @Update("UPDATE course SET `status` = \"PS\" , check_by = #{check_by} WHERE course_id = #{course_id}\n")
    Integer putPass(@Param("course_id") Integer courseId, @Param("check_by") String checkBy);

    @Update("UPDATE course SET `status` = \"RJ\" , check_by = #{check_by} WHERE course_id = #{course_id}\n")
    Integer putRefuse(@Param("course_id") Integer courseId, @Param("check_by") String checkBy);

    @Update("update course_refuse_info set content = #{content} where course_id = #{course_id}")
    Integer changeRefuseInfo(@Param("content") String content, @Param("course_id") Integer courseId);

    @Insert("insert into course_refuse_info (course_id,content) values (#{course_id},#{content})")
    Integer addRufuseInfo(@Param("course_id") Long courseId, @Param("content") String content);

    @Select("SELECT Date(#{time}) dayTime,IFNULL(((SUM(ce.professionalism)+SUM(ce.expression)+SUM(ce.lively)+SUM(ce.`practical`)+SUM(ce" +
            ".`available`))/5/COUNT(1)),0) num FROM course_evaluate ce where DATE(ce.create_time) <= #{time} and course_id = #{course_id} GROUP BY " +
            "dayTime,ce.`course_id` ")
    Map getAvgScore(@Param("course_id") Long courseId, @Param("time") String time);

    @Select("SELECT DATE(#{time}) dayTime,IFNULL(COUNT(1),0) num FROM student_class_learned scl LEFT JOIN course_class cc  ON cc.course_class_id = " +
            "scl.course_class_id where DATE(cc.start_time) = #{time} and course_id = #{course_id}  GROUP BY dayTime")
    Map getPlayNum(@Param("course_id") Long courseId, @Param("time") String time);

    @Select("select date(#{time}) dayTime,ifnull(count(1),0) num from student_course_share where course_id = #{course_id} and date(create_time) = " +
            "#{time} group by dayTime")
    Map getShareNum(@Param("course_id") Long courseId, @Param("time") String time);

    @Select("select date(#{time}) dayTime,ifnull(count(1),0) num from student_course_collect where course_id = #{course_id} and date(create_time) =" +
            " #{time} group by dayTime")
    Map getCollectNum(@Param("course_id") Long courseId, @Param("time") String time);

    @Update("update course set delete_flag = 1 where course_id = #{course_id}")
    Integer delCourse(@Param("course_id") Long courseId);

    @Update("update course_class set delete_flag = 1 where course_id = #{course_id}")
    Integer delClass(@Param("course_id") Long courseId);

}
