package com.tdh.mybatisplus.config;



import java.text.MessageFormat;

/**
 * @Description:
 * @Author : TYQ
 * @Date: 2020-08-13 19:01
 */
public class MarsLdException extends RuntimeException  {

    /**
     * 异常代码
     */
    private String message;


    public MarsLdException(String code, String message) {

        this(new CodeValue(code, message));
    }

    private CodeValue codeValue;

    public MarsLdException(String message) {

        super(message);
    }

    /**
     * @param codeValue
     *            {@link CodeValue}
     *
     */
    public MarsLdException(CodeValue codeValue) {

        setCodeValue(codeValue);
        message = codeValue.getValue();
    }

    /**
     * @param codeValue
     *            {@link CodeValue}
     * @param paramValues
     *            消息的参数值
     */
    public MarsLdException(CodeValue codeValue, Object[] paramValues) {
        this(codeValue);
        formatMessage(paramValues);
    }

    /**
     * 使用提供的参数格式化消息
     *
     * @param paramValues
     */
    public void formatMessage(Object[] paramValues) {

        message = MessageFormat.format(codeValue.getValue(), paramValues);
    }

    /**
     * 获取错误代码
     *
     * @return 错误代码
     */
    public String getCode() {

        if (null == getCodeValue()) {
            return "100000";
        }

        return getCodeValue().getCode();
    }

    @Override
    public String getMessage() {

        return this.message;
    }

    @Override
    public String toString() {

        return getCode() + " - " + getMessage();
    }

    public CodeValue getCodeValue() {

        return codeValue;
    }

    private void setCodeValue(CodeValue codeValue) {

        this.codeValue = codeValue;
    }



}
