package com.example.springmvcexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class SpringmvcExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcExamplesApplication.class, args);
    }

    // 启动方法级校验
    @Bean
    public MethodValidationPostProcessor getMethodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    // 直接将passwordEncoder组件注入容器
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
