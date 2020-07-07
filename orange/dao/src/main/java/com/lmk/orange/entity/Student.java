package com.lmk.orange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.lmk.orange.vo.UserInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 学员
 * </p>
 *
 * @author caihualong
 * @since 2020-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Student  extends Model implements UserInterface {

    private static final long serialVersionUID = 1L;

    @TableId(value = "student_id", type = IdType.AUTO)
    private Long studentId;

    /**
     * 账号
     */
    private String account;

    /**
     * 手机号
     */
    private Long mobile;

    /**
     * 密码
     */
    private String password;

    private String headUrl;

    /**
     * 昵称
     */
    private String wechatNikename;

    /**
     * 微信unionid
     */
    private String wechatUnionid;

    /**
     * 微信公众id
     */
    private String wechatPublicOpenid;

    /**
     * 微信小程序id
     */
    private String wechatAppletOpenid;

    /**
     * 允许评价 1允许，0不允许
     */
    private Boolean canEvaluate;

    /**
     * 允许举报 1允许，0不允许
     */
    private Boolean canReport;

    /**
     * 性别 1男性，2女性
     */
    private Integer sex;

    private String country;

    private String province;

    private String city;

    private LocalDateTime createTime;

    private String createBy;

    private LocalDateTime updateTime;

    private String updateBy;

    private Boolean deleteFlag;

}
