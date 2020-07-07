package com.lmk.orange.common;

import io.swagger.annotations.ApiModelProperty;

public class ResponseResult<T> {

    @ApiModelProperty("状态代码")
    private String status;
    @ApiModelProperty("状态消息")
    private String msg;
    @ApiModelProperty("返回数据")
    private T data;

    public ResponseResult() {
        this.status = Constants.SUCCESS_CODE;
        this.msg = "请求成功";
    }
    public ResponseResult(String msg) {
        this.status = Constants.SUCCESS_CODE;
        this.msg = msg;
    }
    public ResponseResult(T data) {
        this();
        this.data = data;
    }

    public ResponseResult(ErrorType errorType) {
        this.status = errorType.getCode();
        this.msg = errorType.getMsg();
    }

    public ResponseResult(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }
    public ResponseResult(String msg, T data) {
        super();
        this.status = Constants.SUCCESS_CODE;
        this.msg = msg;
        this.data = data;
    }
    public ResponseResult(String status, String msg, T data) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
