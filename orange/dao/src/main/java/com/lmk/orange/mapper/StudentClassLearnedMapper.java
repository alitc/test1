package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmk.orange.entity.StudentClassLearned;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 学生课节学习进度 Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-16
 */
@Repository
public interface StudentClassLearnedMapper extends BaseMapper<StudentClassLearned> {

    /**
     * 查询学生未学完的课节总数
     */
    @Select("select count(1) notFinishCount\n" +
            " from course_class c left join student_class_learned l on c.course_class_id=l.course_class_id \n" +
            "where c.course_id = #{courseId}\n" +
            " and ifnull(l.finish,0)=0\n" +
            " and l.student_id = #{studentId}")
    Integer countNotLearned(@Param("courseId") Integer courseId, @Param("studentId") Long studentId);

    @Select("select sum(learned_time) learnDuration " +
             "from student_class_learned l where  l.course_id = #{courseId} and l.student_id = #{studentId}")
    Long  getDuration(@Param("courseId") Integer courseId, @Param("studentId") Long studentId);

    @Delete("delete from student_class_learned where student_id = #{student_id} and course_class_id = #{course_class_id} ")
    Integer delClassHistory(@Param("student_id") Long studentId, @Param("course_class_id") Long courseClassId);


}
