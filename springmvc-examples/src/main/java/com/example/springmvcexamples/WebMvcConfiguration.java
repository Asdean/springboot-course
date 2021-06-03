package com.example.springmvcexamples;

import com.example.springmvcexamples.example06.interceptor.LoginInterceptor06;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor06 loginInterceptor06;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor06)
                .addPathPatterns("/api/example06/admin/**");
    }
}
