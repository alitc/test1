package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.CourseEvaluateReport;
import com.lmk.orange.vo.CourseEvaluateReportVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @author WangShijun
 * @date 2020/4/28 10:55
 */
@Repository
public interface CourseEvaluateReportMapper extends BaseMapper<CourseEvaluateReport> {

    @Select("select cer.student_id,s.wechat_nikename,s.head_url,cer.ce_id,cer.id,cer.report_id,cer.report_time from course_evaluate_report cer" +
            " left join student s on s.student_id = cer.student_id where cer.ce_id = #{ceId} ")
    IPage<CourseEvaluateReportVo>  listCourseEvaluateReport(Page page, @Param("ceId") Long ceId);



}
