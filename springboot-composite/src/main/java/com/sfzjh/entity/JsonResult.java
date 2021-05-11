package com.sfzjh.entity;

import com.sfzjh.exception.BusinessMsgEnum;

/**
 * @Author 孙飞
 * @Date 2021年04月30日  9:37
 * @PackageName com.sfzjh.entity
 * @Name JsonResult
 * @Version 1.0
 * @Description 统一返回对象
 * Created with IntelliJ IDEA.
 */
public class JsonResult<T> {
    private T data;
    private String code;
    private String message;

    /**
     * 若没有数据返回，默认状态码为0，提示信息为：操作成功！
     * @author 孙飞
     * @date 2021年04月30日  09:38
     */
    public JsonResult(){
        this.code = "0";
        this.message = "操作成功！";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @author 孙飞
     * @date 2021年04月30日  09:39
     * @param code 状态码
     * @param message 状态信息
     */
    public JsonResult(String code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 有数据返回时，状态码为0，默认提示信息为：操作成功！
     * @author 孙飞
     * @date 2021年04月30日  09:41
     * @param data 返回的数据
     */
    public JsonResult(T data){
        this.data = data;
        this.code = "0";
        this.message = "操作成功！";
    }

    /**
     * 有数据返回，状态码为0，人为指定提示信息
     * @author 孙飞
     * @date 2021年04月30日  09:42
     * @param data 返回数据
     * @param message 状态信息
     */
    public JsonResult(T data, String message) {
        this.data = data;
        this.code = "0";
        this.message = message;
    }

    /**
     * 使用自定义异常作为参数传递状态码和提示信息
     * @author 孙飞
     * @date 2021年04月30日  10:36
     * @param msgEnum 枚举类型
     */
    public JsonResult(BusinessMsgEnum msgEnum){
        this.code = msgEnum.getCode();
        this.message = msgEnum.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }
}
