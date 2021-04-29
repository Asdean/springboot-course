package com.example.springexamples.example03.joinpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AOPService03 {
    public String hello(String name) {
        return "welcome " + name;
    }
}
