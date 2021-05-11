package com.sfzjh.exception;

import com.sfzjh.entity.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author 孙飞
 * @Date 2021年04月30日  9:34
 * @PackageName com.sfzjh.exception
 * @Name GlobalExceptionHandler
 * @Version 1.0
 * @Description 全局异常处理
 * Created with IntelliJ IDEA.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 拦截业务异常，返回业务异常信息
     * @author 孙飞
     * @date 2021年04月30日  10:44
     * @param exception 业务异常信息
     * @return com.sfzjh.entity.JsonResult
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleBusinessError(BusinessErrorException exception) {
        String code = exception.getCode();
        String message = exception.getMessage();
        return new JsonResult(code, message);
    }

    /**
     * 空指针异常
     * @author 孙飞
     * @date 2021年04月30日  10:49
     * @param exception 空指针异常
     * @return com.sfzjh.entity.JsonResult
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleTypeMismatchException(NullPointerException exception){
        logger.error("空指针异常，{}", exception.getMessage());
        return new JsonResult("500", "空指针异常了");
    }

    /**
     * 缺少请求参数异常
     * @author 孙飞
     * @date 2021年04月30日  10:49
     * @param exception 异常信息
     * @return com.sfzjh.entity.JsonResult
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleHttpMessageNotReadableException(
            MissingServletRequestParameterException exception) {
        logger.error("缺少请求参数，{}", exception.getMessage());
        return new JsonResult("400", "缺少必要的请求参数");
    }

    /**
     * 系统异常 预期以外异常
     * @author 孙飞
     * @date 2021年04月30日  10:50
     * @param exception 异常信息
     * @return com.sfzjh.entity.JsonResult
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleUnexpectedServer(Exception exception) {
        logger.error("系统异常：", exception);
        return new JsonResult(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
    }
}
