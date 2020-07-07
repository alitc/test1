package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.Student;
import com.lmk.orange.vo.CityRankingVo;
import com.lmk.orange.vo.ProvinceRankingVo;
import com.lmk.orange.vo.StudentPageVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学员 Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-07
 */
@Repository
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select count(1) from student_focus_teacher where student_id =#{studentId} and teacher_id =#{teacherId} ")
    boolean isFocusTeacher(@Param("studentId") Long studentId, @Param("teacherId") Long teacherId);

    @Select(" SELECT DATE(#{time}) dayTime ,ifnull(SUM(s.personNum),0) personNum FROM \n" +
            " (SELECT DATE(s.create_time) dayTime ,ifnull(COUNT(1),0) personNum FROM student s WHERE DATE(create_time) <= #{time} GROUP BY dayTime)s")
    Map getTotalNum(@Param("time") String time);

    @Select("select Date(#{time}) dayTime , ifnull(count(1),0) personNum from student_clock sc where DATE(create_time) = #{time}  group by dayTime ")
    Map getLoginNum(@Param("time") String time);

    @Select("select province,personNum,proportion from (select s1.province,count(1) personNum,count(1)/s2.total proportion from student s1,(select count(1) total from student )s2 group by s2.total,s1.province)s group by personNum DESC,proportion,province")
    List<ProvinceRankingVo> getProvinceRanking();

    @Select("SELECT city,personNum,proportion FROM (SELECT s1.city,COUNT(1) personNum,COUNT(1)/s2.total proportion FROM student s1,(SELECT COUNT(1) total FROM student )s2 where s1.province = #{province} GROUP BY s2.total,s1.city)s GROUP BY personNum DESC,proportion,city")
    List<CityRankingVo> getCityRanking(String province);

    @Update("update student set can_evaluate = 1 where student_id = #{student_id}")
    Integer canEvaluate(@Param("student_id") Long studentId);

    @Update("update student set can_evaluate = 0 where student_id = #{student_id}")
    Integer banEvaluate(@Param("student_id") Long studentId);

    @Update("update student set can_report = 1 where student_id = #{student_id}")
    Integer canReport(@Param("student_id") Long stuentId);

    @Update("update student set can_report = 0 where student_id = #{student_id}")
    Integer banReport(@Param("student_id") Long studentId);

    @Select("select s.`student_id`,s.`account`,s.`mobile`,s.`head_url`,s.`wechat_nikename`,s.`age`,s.`sex`,s.`country`,s.`province`,s.`city`,ifnull(scs.shareNum,0)shareNum ,ifnull(ce.evaluateNum ,0) evaluateNum,ifnull(sft.focusNum,0) focusNum,ifnull(scc.collectNum,0) collectNum,s.`can_evaluate`,s.`can_report` from student s left join (SELECT sft.`student_id`,COUNT(1) focusNum FROM student_focus_teacher sft GROUP BY sft.`student_id`  ) sft on sft.student_id = s.`student_id` left join (SELECT scc.`student_id`,COUNT(1) collectNum FROM student_course_collect scc GROUP BY scc.`student_id`) scc on scc.student_id = s.`student_id` left join (select ce.`student_id`,count(1) evaluateNum from course_evaluate ce group by ce.`student_id`) ce on ce.student_id = s.`student_id` left join (select scs.`student_id`,count(1) shareNum from student_course_share scs group by scs.`student_id`) scs on scs.student_id = s.`student_id` ${ew.customSqlSegment}")
    IPage<StudentPageVo> getStudentPage(Page page, @Param("ew") QueryWrapper wrapper);

    @Select("SELECT IFNULL(sex,0) sex,COUNT(1) num,COUNT(1)/(SELECT COUNT(1) FROM student) proportion FROM student GROUP BY sex ")
    List<Map> getStudentSex();

    @Select("SELECT s.myage ,s.num,s.proportion FROM (SELECT CASE WHEN age>=0 AND age<=6 THEN 1 WHEN age>=7 AND age<=17 THEN 2 WHEN age>=18 AND age<=28 THEN 3 WHEN age>=29 AND age <=40 THEN 4 WHEN age>=41 AND age<=65 THEN 5 WHEN age>=66 THEN 6 ELSE 0 END myage ,COUNT(1) num,COUNT(1)/(SELECT COUNT(1) FROM student) proportion FROM student GROUP BY myage)s")
    List<Map> getStudentAge();

    @Select("select Date(#{time}) dayTime , ifnull(count(1),0) personNum from student s where DATE(create_time) = #{time}  group by dayTime ")
    Map getNewNum(@Param("time") String time);

    @Select("\n" +
            "SELECT DATE(sc.create_time) dayTime,ifnull(COUNT(1)/(SELECT COUNT(1) newNum FROM student s WHERE DATE(#{time}) - DATE(s.create_time) = #{dayInterval} ),0) proportion FROM student s LEFT JOIN student_clock sc ON sc.`student_id` = s.student_id WHERE DATE(#{time}) - DATE(s.create_time) = 1 AND DATE(sc.`create_time`) = DATE(#{time}) GROUP BY dayTime ")
    Map getRetentionRate(@Param("dayInterval") Integer dayInterval, @Param("time") String time);
}
