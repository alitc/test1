package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmk.orange.entity.StudentMessageRead;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 消息阅读 Mapper 接口
 * </p>
 * @author caihualong
 * @since 2020-04-14
 */
@Repository
public interface StudentMessageReadMapper extends BaseMapper<StudentMessageRead> {
    @Select("replace INTO student_message_read (message_id,student_id) VALUES (#{message_id},#{student_id})")
    Integer isRead(@Param("message_id") Long messageId, @Param("student_id") Long studentId);

}
