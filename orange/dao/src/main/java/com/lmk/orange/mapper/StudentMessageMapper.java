package com.lmk.orange.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmk.orange.entity.StudentMessage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  消息 Mapper 接口
 * </p>
 * @author caihualong
 * @since 2020-04-14
 */
@Repository
public interface StudentMessageMapper extends BaseMapper<StudentMessage> {

    @Select("select st.*,(case when smr.message_id is not null then 1 else 0 end ) is_read \n" +
            "  from student_message st left join student_message_read smr on st.message_id=smr.message_id \n" +
            " where (st.student_id =#{userId} or st.student_id is null)   \n" +
            "  order by is_read desc,create_time desc limit 0,3 ")
    List<StudentMessage> getByUserIdTop(@Param("userId") Long userId);


    @Select("SELECT sm.message_id ,sm.message_type,sm.message_title,sm.message_content,sm.student_id,sm.create_time FROM student_message sm WHERE sm.student_id = #{student_id} AND sm.`message_type` = #{message_type} ORDER BY sm.`create_time` DESC")
    IPage<StudentMessage> quaryUserMessage(Page page, @Param("student_id") Long studentId, @Param("message_type") Integer messageType);

    @Select("select count(1) num,UNIX_TIMESTAMP(max(create_time))*1000 time,message_type from( \n" +
            "   select st.message_type,st.create_time,st.message_title,                   \n" +
            "        (case when smr.message_id is not null then 1 else 0 end ) is_read    \n" +
            "      from student_message st left join student_message_read smr on st.message_id=smr.message_id \n" +
            "   where (st.student_id =#{studentId} or st.student_id is null)              \n" +
            ") t where is_read =0 group by message_type " )
    List<HashMap<String,Object>> notReadMessageCount(Long studentId);

    @Select("select create_time from student_message where student_id = #{student_id} and message_type = #{message_type} order by create_time desc limit 1")
    LocalDateTime lastMassageTime(@Param("student_id") Long studentId, @Param("message_type") Long messageType);


}
