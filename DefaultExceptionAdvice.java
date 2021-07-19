package com.joinutech.storage.advice;

import com.joinutech.eshop.common.exception.BaseException;
import com.joinutech.eshop.common.vo.Result;
import com.joinutech.storage.exception.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * 异常处理
 */
@ResponseBody
@Slf4j
@ControllerAdvice
public class DefaultExceptionAdvice {
    /**
     * IllegalArgumentException异常处理返回json
     */
    @ExceptionHandler({IllegalArgumentException.class})
    public Result badRequestException(IllegalArgumentException e) {
        return defHandler("参数解析失败", e);
    }

    /**
     * AccessDeniedException异常处理返回json
     */
    @ExceptionHandler({AccessDeniedException.class})
    public Result badMethodExpressException(AccessDeniedException e) {
        return defHandler("没有权限请求当前方法", e);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return defHandler("不支持当前请求方法", e);
    }

    /**
     * SQLException sql异常处理
     */
    @ExceptionHandler({SQLException.class})
    public Result handleSQLException(SQLException e) {
        return defHandler("服务运行异常", e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        log.error("属性字段校验异常：{}", errorMessage);
        return Result.fail(errorMessage);
    }

    /**
     * 所有异常统一处理
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return defHandler("未知异常", e);
    }

    private Result defHandler(String msg, Exception e) {
        log.error(msg, e);
        return Result.fail(msg);
    }

    @ExceptionHandler(BaseException.class)
    public Result baseException(BaseException e) {
        log.error(e.getCodeAndMessage().toString());
        return new Result(e.getCodeAndMessage(), "");
    }

    @ExceptionHandler(StorageException.class)
    public Result pointException(StorageException e) {
        log.error(e.getCodeAndMessage().toString());
        return new Result(e.getCodeAndMessage(), "");
    }

}
