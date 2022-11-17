package com.tdh.mybatisplus.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description:
 * @Author : TYQ
 * @Date: 2020-08-16 11:31
 */
@ToString
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    public final static int FAIL = 400;
    public final static int SUCCESS = 200;
    public final static int SESSION_TIMEOUT = 403;
    //    public final static int EXCEPTION = 3;
    public final static int FORBIDDEN = 401;

    public final static int NOSELECTEDORG = 2001;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private boolean success;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private T body;

    @Getter
    @Setter
    private T data;


    public static <T> R<T> ok() {
        return restResult(null, SUCCESS, true, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, SUCCESS, true, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, true, msg);
    }

    public static <T> R<T> failed() {
        return restResult(null, FAIL, false, null);
    }

    public static <T> R<T> failed(String msg) {
        return restResult(null, FAIL, false, msg);
    }

    public static <T> R<T> failed(T data) {
        return restResult(data, FAIL, false, null);
    }

    public static <T> R<T> failed(int code, String msg) {
        return restResult(null, code, false, msg);
    }


    public static <T> R<T> failed(T data, String msg) {
        return restResult(data, FAIL, false, msg);
    }

    private static <T> R<T> restResult(T data, int code, boolean success, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setBody(data);
        apiResult.setMessage(msg);
        apiResult.setSuccess(success);
        return apiResult;
    }


}
