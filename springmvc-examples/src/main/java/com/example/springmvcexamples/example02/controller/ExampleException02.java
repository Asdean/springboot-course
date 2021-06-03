package com.example.springmvcexamples.example02.controller;

import com.example.springmvcexamples.example02.exception.MyException;
import com.example.springmvcexamples.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExampleException02 {
    @ExceptionHandler(MyException.class)
    public ResultVO handleValidException(MyException exception) {
        return ResultVO.error(exception.getCode(), exception.getMessage());
    }
}
