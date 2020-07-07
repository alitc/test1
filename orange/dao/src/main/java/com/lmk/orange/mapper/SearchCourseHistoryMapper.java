package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.SearchCourseHistory;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学生搜索课程历史 Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-19
 */
@Repository
public interface SearchCourseHistoryMapper extends BaseMapper<SearchCourseHistory> {


    @Select("select name,count(1) num, max(create_time) create_time from search_course_history group by name order by num,create_time")
    IPage<SearchCourseHistory> searchMore(Page page);

    @Select("SELECT sch.name,COUNT(1) todayNum,IFNULL(sch2.yesterdayNum,0) yesterdayNum FROM search_course_history sch LEFT JOIN (SELECT NAME,COUNT(1) yesterdayNum FROM search_course_history WHERE DATE(NOW()) - DATE(create_time) = 1 GROUP BY `name`) sch2 ON sch.`name`=sch2.name WHERE DATE(sch.create_time) = DATE(NOW())  GROUP BY sch.`name` ORDER BY todayNum DESC")
    List<Map> getRanking();

}
