package com.lmk.orange.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author WangShijun
 * @date 2020/4/28 10:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CourseEvaluateReportVo  extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Long studentId;

    private Integer ceId;

    @ApiModelProperty("     1  违法违规     \n" +
            "     2  色情、低俗  \n" +
            "     3  广告           \n" +
            "     4  人身攻击     \n" +
            "     5  血腥暴力     \n" +
            "     6  其他    ")
    private Integer reportId;

    private LocalDateTime reportTime;

    private String wechatNikename;

    private String headUrl;




}
