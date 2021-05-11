package com.sfzjh.exception;

import lombok.Data;

/**
 * @Author 孙飞
 * @Date 2021年04月30日  9:26
 * @PackageName com.sfzjh.exception
 * @Name BusinessErrorException
 * @Version 1.0
 * @Description 自定义业务异常
 * Created with IntelliJ IDEA.
 */
@Data
public class BusinessErrorException extends RuntimeException {
    private static final long serialVersionUID = -7480022450501760611L;

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常信息
     */
    private String message;
}
