package com.example.springmvcexamples.example03.beanexception.controller;

import com.example.springmvcexamples.example03.beanexception.extity.User03;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/example03/")
@Validated // 方法上或方法参数使用校验约束时必须声明
public class ExampleController03 {
    @PostMapping("users")
    public void postUser(@Valid @RequestBody User03 user) {
    }

    @GetMapping("users/{uid}/file")
    public void getFile(@PathVariable int uid) {
    }

    @GetMapping("users/{owner}")
    public void getViolationException(
            @Size(min = 2, max = 6, message = "用户信息错误")
            @PathVariable String owner) {
    }
}
