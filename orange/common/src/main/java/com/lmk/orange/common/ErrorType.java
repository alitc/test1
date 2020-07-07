package com.lmk.orange.common;

public class ErrorType {
    public static final ErrorType ERROR_WRONG = new ErrorType("500", "ERROR_WRONG", "操作发生异常，请联系管理员");
    public static final ErrorType SYSTEM_PARAMETER_ERROR_ERROR = new ErrorType("999001", "SYSTEM_PARAMETER_ERROR_ERROR", "请求参数错误");
    public static final ErrorType SYSTEM_UNLOGIN_ERROR = new ErrorType("999007", "SYSTEM_UNLOGIN_ERROR", "未登录！");
    public static final ErrorType SYSTEM_AUTH_HEADER_ERROR = new ErrorType("999009", "SYSTEM_AUTH_HEADER_ERROR", "无法获取认证头部信息");
    public static final ErrorType SYSTEM_AUTH_PARAM_MISS = new ErrorType("999011", "SYSTEM_AUTH_PARAM_MISS", "缺少认证参数");
    public static final ErrorType ERROR_USER_PASSWORD = new ErrorType("999012", "ERROR_USER_PASSWORD", "用户名或密码错误");
    public static final ErrorType LOGIN_OUT_TIME = new ErrorType("999013", "LOGIN_OUT_TIME", "登录失效！");
    public static final ErrorType ERROR_PARAMETER_REPEACE = new ErrorType("999014", "ERROR_PARAMETER_REPEACE", "两次密码不一致");
    public static final ErrorType PARAMETER_PASSWORD_ERROR = new ErrorType("999015", "PARAMETER_PASSWORD_ERROR", "密码错误");
    public static final ErrorType ERROR_PASSWORD_EMPTY =  new ErrorType("999016","ERROR_PASSWORD_EMPTY","修改失败，密码不能为空");
    public static final ErrorType ERROR_PHONE_EMPTY =  new ErrorType("999017","ERROR_PHONE_EMPTY","手机号不能为空");
    public static final ErrorType ERROR_PHONE_FORMAT =  new ErrorType("999018","ERROR_PHONE_FORMAT","手机号格式不正确");
    public static final ErrorType ERROR_PHONE_RIGISTER =  new ErrorType("999019","ERROR_PHONE_RIGISTER","手机号未注册");
    public static final ErrorType ERROR_PHONE_HASRIGISTER =  new ErrorType("999008","ERROR_PHONE_HASRIGISTER","当前手机号已注册,且处于激活状态");

    public static final ErrorType ERROR_SMS_NOTGET =  new ErrorType("999020","ERROR_SMS_NOTGET","获取验证码失败");
    public static final ErrorType ERROR_SAVE =  new ErrorType("999021","ERROR_SAVE_BACTH","保存失败");
    public static final ErrorType ERROR_NOUPLOAD_FILE =  new ErrorType("999022","ERROR_NOUPLOAD_FILE","未选择文件上传");
    public static final ErrorType ERROR_DEAL_FAILURE =  new ErrorType("999023","ERROR_DEAL_FAILURE","处理失败");
    public static final ErrorType ERROR_UPDATE_NODATA =  new ErrorType("999023","ERROR_UPDATE_NODATA","更新失败数据,不存在");
    public static final ErrorType ERROR_NODATA =  new ErrorType("999024","ERROR_NODATA","未找到数据");
    public static final ErrorType ERROR_COMNIT_NOTDATA=  new ErrorType("999025","ERROR_COMNIT_NOTDATA","未提交数据");
    public static final ErrorType ERROR_COUSTOMER_HASCOMMIT=  new ErrorType("999026","ERROR_COUSTOMER_HASCOMMIT","已提交客户不允许修改");
    public static final ErrorType ERROR_NOT_CREATBY=  new ErrorType("999027","ERROR_NOT_CREATBY","非创建人员无权操作");
    public static final ErrorType INSERT_USER_ERROR =  new ErrorType("999028","INSERT_USER_ERROR","新增用户失败");
    public static final ErrorType INSERT_USER_AREA_ERROR =  new ErrorType("999029","INSERT_USER_AREA_ERROR","区域不正确");
    public static final ErrorType ERROR_NOUPLOAD_IMAGE =  new ErrorType("999030","ERROR_NOUPLOAD_IMAGE","图片上传失败！");
    public static final ErrorType ERROR_MESSAGE_REPLY =  new ErrorType("999031","ERROR_MESSAGE_REPLY","回复信息短信发送失败！");
    public static final ErrorType REPEAT_NUMBER =  new ErrorType("999030","REPEAT_NUMBER","重复号码");
    public static final ErrorType SMS_FAILED_TO_SEND =  new ErrorType("999031","SMS_FAILED_TO_SEND","短信发送失败");
    public static final ErrorType MAX_UPLOAD_SIZE_EXCEEDED =  new ErrorType("999032","MAX_UPLOAD_SIZE_EXCEEDED","文件太大无法上传");
    public static final ErrorType SYSTEM_NOT_PORWORD = new ErrorType("999033", "SYSTEM_NOT_PORWORD", "无访问权限！");
    public static final ErrorType SYSTEM_SUBSCRIBED_COURSE = new ErrorType("999034", "SYSTEM_SUBSCRIBED_COURSE", "预约失败，已预约课程！");
    public static final ErrorType SYSTEM_COLLECT_COURSE = new ErrorType("999035", "SYSTEM_COLLECT_COURSE", "收藏失败，已收藏课程！");
    public static final ErrorType SYSTEM_FOCUSED_TEACHER = new ErrorType("999036", "SYSTEM_FOCUS_TEACHER", "关注失败，已关注该教师");
    public static final ErrorType SYSTEM_NOT_EVALUATE = new ErrorType("999037", "SYSTEM_NOT_EVALUATE", "您已被禁止评价！");
    public static final ErrorType SYSTEM_NOT_REPORT = new ErrorType("999038", "SYSTEM_NOT_EVALUATE", "您已被禁止举报！");
    public static final ErrorType ERROR_INSERT_COURSE =  new ErrorType("999039","ERROR_INSERT_COURSE","新建课程失败！");
    public static final ErrorType SMS_CODE_ERROR =  new ErrorType("999040","SMS_CODE_ERROR","验证码错误或已过期！");

    // 成员变量
    String code;
    String name;
    String msg;
    String addMsg;

    public ErrorType(){};

    // 构造方法
    public ErrorType(String code, String name, String msg) {
        this.name = name;
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAddMsg() {
        return addMsg;
    }

    public void setAddMsg(String addMsg) {
        this.addMsg = addMsg;
    }

    @Override
    public String toString() {
        return "{" +
                "  code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", msg='" + msg  + '\'' + ((addMsg==null||addMsg.trim()=="") ? "" : ("：" + addMsg)) +
                '}';
    }
}
