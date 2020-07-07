package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.StudentCourseLearned;
import com.lmk.orange.vo.ClassLearnedHistoryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-16
 */
@Repository
public interface StudentCourseLearnedMapper extends BaseMapper<StudentCourseLearned> {

    @Select("SELECT cc.course_id,cc.course_class_id ,cc.`title`,cc.`video_url`,ROUND(scl.learned_time / cc.`duration`,3) learned,scl.end_time , c.course_name ,c.`teacher_id`,t.teacher_name ,t.`head_url`  FROM course_class cc RIGHT JOIN (SELECT student_id ,course_class_id,start_time,end_time,learned_time,finish FROM student_class_learned WHERE student_id = #{student_id}) scl ON cc.course_class_id =  scl.course_class_id LEFT JOIN course c ON c.course_id = cc.course_id LEFT JOIN teacher t ON t.`teacher_id` = c.`teacher_id`  ORDER BY scl.end_time DESC ")
    IPage<ClassLearnedHistoryVo> learnHistory(Page page, @Param("student_id") Long studentId);




}
