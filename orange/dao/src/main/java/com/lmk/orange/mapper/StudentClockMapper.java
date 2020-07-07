package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.lmk.orange.entity.StudentClock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-15
 */
@Repository
public interface StudentClockMapper extends BaseMapper<StudentClock> {


    @Select("select * from student_clock where yearMoth =#{yearMoth} and student_id=#{studentId} and day=#{day}")
    StudentClock queryByDay(@Param("yearMoth") String yearMoth, @Param("studentId") Long studentId, @Param("day") String day);

    @Select("select day from student_clock where yearMoth =#{yearMoth} and student_id=#{studentId}")
    List<String> queryVosByMoth(@Param("yearMoth") String yearMoth, @Param("studentId") Long studentId);

}
