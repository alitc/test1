package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.Feedback;
import com.lmk.orange.vo.FeedbackVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 意见反馈 Mapper 接口
 * </p>
 *
 * @author caihualong
 * @since 2020-04-22
 */
@Repository
public interface FeedbackMapper extends BaseMapper<Feedback> {

    @Select("SELECT f.feedback_id,f.student_id,s.wechat_nikename,s.head_url,s.mobile,s.`sex`,f.feedback_type,f.feedback_message,f.feedback_reply,f" +
            ".feedback_img_url,f.feedback_time,case when f.feedback_reply is not null then 2 when f.note = 1 then 1 else 0 end note  FROM \n" +
            "(SELECT f.feedback_id,f.student_id,f.feedback_type,f.feedback_message,fi.feedback_img_url,f.feedback_time,f.feedback_reply,f.`note` FROM feedback f LEFT JOIN feedback_img fi ON fi.feedback_id = f.feedback_id)f\n" +
            "LEFT JOIN student s ON s.`student_id` = f.student_id  ${ew.customSqlSegment}" )
    IPage<FeedbackVo> getPage(Page page, @Param("ew") QueryWrapper wrapper);



}
