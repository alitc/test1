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
 *
 * </p>
 *
 * @author caihualong
 * @since 2020-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Teacher  extends Model implements UserInterface {

    private static final long serialVersionUID = 1L;

    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Long teacherId;

    /**
     * 教师名称
     */
    private String teacherName;

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
     * 介绍
     */
    private String introduce;

    /**
     * 介绍图片
     */
    private String introduceUrl;

    /**
     * 专长
     */
    private String expert;

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
     * 性别 1男性，2女性
     */
    private Integer sex;

    private LocalDateTime createTime;

    private String createBy;

    private LocalDateTime updateTime;

    private String updateBy;

    private Boolean deleteFlag;
    /**
     * 讲师资质
     */
    private String qualification;
    /**
     * 角色权限
     */
    private Integer rule;


}
