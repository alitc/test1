package com.lmk.orange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/5/12 10:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel("通知中心")
public class MessageCenter extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long ceId;

    private Long courseId;

    private Long courseClassId;

    private Long feedbackId;

    private Long studentId;

    private Long teacherId;

    private Integer noticeType;

    private LocalDateTime createTime;

    private Long cerId;

    private Long reportId;

}
