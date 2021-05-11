package com.sfzjh.exception;

/**
 * @Author 孙飞
 * @Date 2021年04月30日  9:29
 * @PackageName com.sfzjh.exception
 * @Name BusinessMsgEnum
 * @Version 1.0
 * @Description 业务异常提示信息枚举类
 * Created with IntelliJ IDEA.
 */
public enum BusinessMsgEnum {
    /**
     * 参数异常
     */
    PARMETER_EXCEPTION("102", "参数异常!"),
    /**
     * 等待超时
     */
    SERVICE_TIME_OUT("103", "服务调用超时！"),
    /**
     *  参数过大
     */
    PARMETER_BIG_EXCEPTION("102", "输入的图片数量不能超过50张!"),
    /**
     * 500 : 发生异常
     */
    UNEXPECTED_EXCEPTION("500", "系统发生异常，请联系管理员！");

    private String code;
    private String message;

    BusinessMsgEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
