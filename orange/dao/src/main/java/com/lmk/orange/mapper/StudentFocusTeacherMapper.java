package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.StudentFocusTeacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 学员关注教师 Mapper 接口
 * </p>
 * @author caihualong
 * @since 2020-04-19
 **/
@Repository
public interface StudentFocusTeacherMapper extends BaseMapper<StudentFocusTeacher> {
    @Select("SELECT sft.student_id,sft.teacher_id,sft.create_time,t.qualification,t.teacher_name,t.head_url,t.expert,t.introduce,sft.create_time FROM student_focus_teacher sft , teacher t WHERE t.`teacher_id` = sft.`teacher_id` AND student_id = #{student_id}")
    IPage<StudentFocusTeacher> getFocusTeacher(Page page, @Param("student_id") Long studentId);


}

