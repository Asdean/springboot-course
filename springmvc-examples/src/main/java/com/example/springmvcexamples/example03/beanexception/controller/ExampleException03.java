package com.example.springmvcexamples.example03.beanexception.controller;

import com.example.springmvcexamples.vo.ResultVO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class ExampleException03 {
    /**
     * 属性校验失败异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleValidException(MethodArgumentNotValidException exception) {
        StringBuffer stringBuffer = new StringBuffer();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(e -> {
                    stringBuffer.append(e.getField());
                    stringBuffer.append(":");
                    stringBuffer.append(e.getDefaultMessage());
                    stringBuffer.append(";");
                });
        return ResultVO.error(400, stringBuffer.toString());
    }

    /**
     * 请求地址参数类型不匹配
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultVO handleTypeMismatchException(MethodArgumentTypeMismatchException exception,
                                                HttpServletRequest request) {
        String msg = request.getRequestURI() + ":请求地址参数"
                + exception.getValue()  + "错误";
        return ResultVO.error(400, msg);
    }

    /**
     * jackson json格式转换异常
     * @param exception
     * @return
     */
    @ExceptionHandler(InvalidFormatException.class)
    public ResultVO handleInvalidFormatException(InvalidFormatException exception) {
        StringBuilder stringBuilder = new StringBuilder();
        exception.getPath()
                .forEach(p -> {
                    stringBuilder.append("属性：");
                    stringBuilder.append(p.getFieldName());
                    stringBuilder.append(",你输入的值")
                            .append(exception.getValue())
                            .append(",类型错误");
                });
        return ResultVO.error(400, stringBuilder.toString());
    }

    /**
     * 方法级参数校验异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO handleConstraintViolationException(ConstraintViolationException exception) {
        StringBuilder stringBuilder = new StringBuilder();
        //Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        exception.getConstraintViolations()
                .forEach(v -> {
                    stringBuilder.append(v.getMessage())
                            .append(";");
                });
        return ResultVO.error(400, stringBuilder.toString());
    }
}
