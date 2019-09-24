package com.stopboot.admin.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Created by lianyutao on 2017/7/13.
 * <p>
 * 返回结果
 */
@Data
@Slf4j
public class ResultData<T> implements Serializable {

    public static ResultData build() {
        ResultData instance = new ResultData();
        instance.setTimestamp(System.currentTimeMillis());
        return instance;
    }

    /**
     * 数据
     */
    private T data = null;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 结果状态码
     */
    private String code = ResCodeAndMsg.CODE_FAIL;

    /**
     * 结果消息
     */
    private String msg = ResCodeAndMsg.MSG_FAIL;

    /**
     * 具体错误代码
     */
    private String failCode = null;
    /**
     * 具体错误信息
     */
    private String failMsg = null;


    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFailCode() {
        return failCode;
    }

    public ResultData setFailCode(String failCode) {
        this.failCode = failCode;
        return this;
    }

    public String getFailMsg() {
        return failMsg;
    }

    public ResultData setFailMsg(String failMsg) {
        this.failMsg = failMsg;
        return this;
    }

    public ResultData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultData setData(T data) {
        this.data = data;
        return this;
    }

    public ResultData success() {
        this.setCode(ResCodeAndMsg.CODE_SUCCESS);
        this.setMsg(ResCodeAndMsg.MSG_SUCCESS);
        return this;
    }

    public ResultData success(T data) {
        this.setCode(ResCodeAndMsg.CODE_SUCCESS);
        this.setMsg(ResCodeAndMsg.MSG_SUCCESS);
        this.setData(data);
        return this;
    }

    public ResultData fail() {
        this.setCode(ResCodeAndMsg.CODE_FAIL);
        this.setMsg(ResCodeAndMsg.MSG_FAIL);
        this.setFailCode(FailCodeAndMsg.FAIL_CODE_DEFAULT);
        this.setFailMsg(FailCodeAndMsg.FAIL_MSG_DEFAULT);
        return this;
    }

    public ResultData fail(String failCode, String failMsg) {
        this.setMsg(ResCodeAndMsg.MSG_FAIL);
        this.setCode(ResCodeAndMsg.CODE_FAIL);
        this.setFailCode(failCode);
        this.setFailMsg(failMsg);
        return this;
    }

    public ResultData empty() {
        this.setCode(ResCodeAndMsg.CODE_EMPTY);
        this.setMsg(ResCodeAndMsg.MSG_EMPTY);
        return this;
    }

    public ResultData empty(String msg) {
        this.setCode(ResCodeAndMsg.CODE_EMPTY);
        this.setMsg(msg);
        return this;
    }

    public ResultData unauthc() {
        this.setCode(ResCodeAndMsg.CODE_UNAUTHC);
        this.setMsg(ResCodeAndMsg.MSG_UNAUTHC);
        return this;
    }

    public ResultData unauthc(String msg) {
        this.setCode(ResCodeAndMsg.CODE_UNAUTHC);
        this.setMsg(msg);
        return this;
    }

    public ResultData expire() {
        this.setCode(ResCodeAndMsg.CODE_EXPIRE);
        this.setMsg(ResCodeAndMsg.MSG_EXPIRE);
        return this;
    }

    public ResultData expire(String msg) {
        this.setCode(ResCodeAndMsg.CODE_EXPIRE);
        this.setMsg(msg);
        return this;
    }
}
