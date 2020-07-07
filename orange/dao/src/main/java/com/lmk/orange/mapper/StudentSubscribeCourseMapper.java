package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.StudentSubscribeCourse;
import com.lmk.orange.vo.CourseListVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-19
 */
@Repository
public interface StudentSubscribeCourseMapper extends BaseMapper<StudentSubscribeCourse> {


    @Select(" select " +
            "   c.course_id,c.course_name,c.price,c.picture_url," +
            "   c.start_time start_time,UNIX_TIMESTAMP(start_time) start_time_stamp," +
            "   c.start_status,c.ptch_id," +
            "   t.teacher_name,t.head_url headUrl" +
            "  from course c left join teacher t on c.teacher_id=t.teacher_id " +
            " where exists (" +
            "   select 1 from student_subscribe_course s where c.course_id = s.course_id and s.student_id = #{studentId} " +
            ") " )
    IPage<CourseListVo> subscribedList(Page page, @Param("studentId") Long studentId);

}
