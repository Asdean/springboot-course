package com.example.springexamples.example02;

import com.example.springexamples.example02.aop.AOPService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AOPServiceTest {
    @Autowired
    private AOPService aop;

    @Test
    public void get_test() {
        aop.get();
        log.debug(aop.getClass().getName());
    }
}
