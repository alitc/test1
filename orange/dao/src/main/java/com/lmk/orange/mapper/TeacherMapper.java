package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lmk.orange.entity.Teacher;
import com.lmk.orange.vo.TeacherPersonInfoListVo;
import com.lmk.orange.vo.TeacherPersonalInfoVo;
import com.lmk.orange.vo.TeacherVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-07
 */
@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {

    @Select("select * from teacher where teacher_id=#{userId} and delete_flag =0 ")
    Teacher getByUserId(@Param("userId") Long userId);

    @Select("select teacher_id,teacher_name from teacher where delete_flag=0 ")
    List<Map> listAllTeacher();

    @Select("SELECT tc.teacher_id ,IFNULL(scs.shareNum,0) shareNum,tc.teacher_name,IFNULL(c.coursesum,0) courseNum,IFNULL(p.playNum,0) playNum, IFNULL(AVG(ce.score),0) avgScore,IFNULL(SUM(scc.collect),0) collectNum FROM (SELECT t.teacher_id teacher_id,t.`teacher_name` teacher_name,c.`course_id` course_id FROM teacher t  LEFT JOIN course c ON t.teacher_id = c.teacher_id ${ew.customSqlSegment} ) tc LEFT JOIN (SELECT ce.course_id, IFNULL(((SUM(ce.professionalism)+SUM(ce.expression)+SUM(ce.lively)+SUM(ce.`practical`)+SUM(ce.`available`))/5/COUNT(1)),0) score FROM course_evaluate ce GROUP BY ce.`course_id`) ce ON ce.`course_id`=tc.course_id LEFT JOIN (SELECT `course_id` ,IFNULL(COUNT(1),0) collect FROM student_course_collect GROUP BY course_id) scc ON scc.course_id = tc.course_id  LEFT JOIN (SELECT c.teacher_id, COUNT(1) coursesum FROM course c GROUP BY c.teacher_id) c ON c.teacher_id = tc.teacher_id LEFT JOIN ( SELECT c.teacher_id,COUNT(1) playNum FROM (SELECT c.teacher_id,cc.course_id ,cc.course_class_id FROM course_class cc INNER JOIN (SELECT c.teacher_id ,c.course_id FROM course c) c ON cc.course_id = c.course_id)c LEFT JOIN student_class_learned scl ON scl.`course_class_id` = c.course_class_id GROUP BY c.teacher_id) p ON p.teacher_id = tc.teacher_id LEFT JOIN (SELECT c.teacher_id ,IFNULL(SUM(scs.shareNum),0) shareNum FROM course c LEFT JOIN (SELECT scs.course_id ,COUNT(1) shareNum FROM student_course_share scs GROUP BY scs.course_id)scs ON scs.course_id = c.course_id GROUP BY c.teacher_id) scs ON scs.teacher_id = tc.teacher_id GROUP BY tc.teacher_id,tc.teacher_name,c.coursesum,scs.shareNum,p.playNum ")
    IPage<TeacherPersonInfoListVo> TeacherPersonalInfoList(IPage page, @Param("ew") QueryWrapper wrapper);

    @Select("select teacher_id,teacher_name,mobile,rule from teacher where teacher_id = #{id} and delete_flag = 0")
    TeacherPersonalInfoVo viewTeacherInfo(@Param("id") Integer id);

    @Update("update teacher set delete_flag = 1 where teacher_id = #{teacher_id}")
    Integer delTeacherById(@Param("teacher_id") Integer teacherId);

    @Update("UPDATE course SET delete_flag = 1 WHERE course_id IN(\n" +
            "SELECT tc.course_id FROM\n" +
            "(SELECT c.teacher_id,c.`course_id` FROM course c LEFT JOIN teacher t ON t.teacher_id = c.teacher_id GROUP BY c.teacher_id,c.`course_id`) tc WHERE tc.teacher_id = #{teacher_id})")
    Integer delCourseByTeacherId(@Param("teacher_id") Integer teacherId);

    @Update("UPDATE course_class SET delete_flag = 1 WHERE course_id IN(SELECT c.course_id FROM teacher t LEFT JOIN course c ON t.teacher_id = c.`teacher_id` WHERE t.teacher_id = #{teacher_id})")
    Integer delClassByTeacherId(@Param("teacher_id") Integer teacherId);

    @Update("update teacher set password = #{password} where teacher_id = #{teacher_id}")
    Integer changePasswordById(@Param("teacher_id") Integer teacherId, @Param("password") String password);

    @Select("select password from teacher where teacher_id = #{teacher_id}")
    String getPasswordById(@Param("teacher_id") Integer teacherId);

    @Select("select mobile from teacher where teacher_id = #{teacher_id}")
    Long getMobileById(@Param("teacher_id") Integer teacherId);

    @Select("SELECT t.teacher_id,t.teacher_name,t.qualification,t.mobile,t.introduce,t.expert,t.create_time,sft.focusNum,t.account,t.sex,t.head_url,t.create_time FROM teacher t inner join (SELECT ifnull(teacher_id,#{teacher_id}) teacher_id, ifnull(COUNT(1),0) `focusNum` FROM student_focus_teacher WHERE teacher_id = #{teacher_id}) sft on sft.teacher_id = t.teacher_id AND t.`teacher_id` = #{teacher_id} GROUP BY t.teacher_id,t.teacher_name,t.qualification,t.mobile,t.introduce,t.expert,t.create_time,sft.focusNum,t.account,t.sex,t.head_url ,t.create_time")
    TeacherVo getTeacher(@Param("teacher_id") Integer teacherId);







}
