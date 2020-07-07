package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.StudentCourseCollect;
import com.lmk.orange.vo.CourseListVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程收藏 Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-16
 */
@Repository
public interface StudentCourseCollectMapper extends BaseMapper<StudentCourseCollect> {

    @Select(" select " +
            "   c.course_id,c.course_name,c.price,c.picture_url," +
            "   c.start_time start_time,UNIX_TIMESTAMP(max(start_time)) start_time_stamp," +
            "   c.start_status,c.ptch_id," +
            "   t.teacher_name,t.head_url headUrl," +
            "   scc.create_time" +
            "  from course c inner join teacher t on c.teacher_id=t.teacher_id inner join student_course_collect scc on scc.course_id = c.course_id ${ew.customSqlSegment}  group by start_time,c.ptch_id,t.teacher_name,headUrl,c.course_id,c.course_name,c.price,c.picture_url ,scc.create_time")
    IPage<CourseListVo> collectedList(Page page, @Param("studentId") Long studentId, @Param("ew") QueryWrapper queryWrapper);



}
