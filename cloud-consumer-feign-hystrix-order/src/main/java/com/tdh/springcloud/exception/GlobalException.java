package com.tdh.springcloud.exception;

public class GlobalException {

    public String globalFallbackHandler(){
        return "Global异常处理，对方系统服务繁忙，请稍后再试";
    }

}
