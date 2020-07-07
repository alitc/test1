package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmk.orange.dto.CourseClassDto;
import com.lmk.orange.dto.CourseDto;
import com.lmk.orange.entity.Course;
import com.lmk.orange.entity.CourseClass;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课节 Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-21
 */
@Repository
public interface CourseClassMapper extends BaseMapper<CourseClass> {


    @Select(" select" +
            " (case when a =0 then 0 when a=b then 2 else 1 end) start_status," +
            " start_time" +
            " from ( " +
            " select  sum(case when video_url is not null then 1 else 0 end) a,count(1) b,min(start_time) start_time from course_class where course_id = #{courseId} \n" +
            ") t    ")
    Course selectCourseStartStatus(@Param("courseId") Integer courseId);

    @Select("select c.course_id,cc.course_class_id,c.`ptch_id`,c.`course_name`,c.`teacher_id`,c.`start_status`,c.`picture_url`,c.`introduce`,c.`introduce_url`,cc.sort,cc.title,cc.video_url,cc.duration,cc.status,cc.start_time from course_class cc right join course c on c.`course_id`=cc.`course_id` where c.course_id = #{course_id} and cc.delete_flag = 0  group by c.course_id,cc.course_class_id,c.`ptch_id`,c.`course_name`,c.`teacher_id`,c.`start_status`,c.`picture_url`,c.`introduce`,c.`introduce_url`,cc.sort,cc.title,cc.video_url,cc.duration,cc.status,cc.start_time ")
    List<CourseClassDto> queryClassByCourse(@Param("course_id") Integer courseId);

    @Select("SELECT c.course_id ,c.create_time,c.course_name,c.ptch_id,c.teacher_id,t.teacher_name,t.head_url,c.picture_url,c.introduce,c" +
            ".introduce_url," +
            "c.total_duration," +
            "c.STATUS,c.start_status,c.start_time,cri.content FROM course c left join `course_refuse_info` cri  on " +
            "c.course_id = cri.course_id" +
            " left join teacher t on t.teacher_id = c.teacher_id " +
            " WHERE c.course_id = #{course_id} AND " +
            "c.delete_flag = 0 ")
    CourseDto queryCourse(@Param("course_id") Long courseId);

    @Select("SELECT course_id courseId ,course_class_id courseClassId FROM course_class WHERE (UNIX_TIMESTAMP(start_time) - UNIX_TIMESTAMP(NOW())) < 3640 AND ( UNIX_TIMESTAMP(start_time) - UNIX_TIMESTAMP(NOW())) > 3560 and (status = 0 or video_url is null)")
    List<Map> getNoVideoClass();

    @Select("select course_id ,course_class_id  from course_class where status = 1 and (UNIX_TIMESTAMP(start_time) - UNIX_TIMESTAMP(NOW())) < 3640 AND ( UNIX_TIMESTAMP(start_time) - UNIX_TIMESTAMP(NOW())) > 0 ")
    List<Map> getHaveVideoClass();

    @Update("update course_class set delete_flag = 1 where course_id = #{course_id}")
    Integer delClass(@Param("course_id") Long courseId);

    @Update("update course_class set delete_flag = 0 where course_id = #{course_id} and sort = #{sort} ")
    Integer returnClass(@Param("course_id") Long courseId, @Param("sort") Integer sort);


    @Override
    int insert(CourseClass entity);
}
