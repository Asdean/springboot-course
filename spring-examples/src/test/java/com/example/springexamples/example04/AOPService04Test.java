package com.example.springexamples.example04;

import com.example.springexamples.example04.aopadvanced.AOPService04;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AOPService04Test {
    @Autowired
    private AOPService04 aopService04;

    @Test
    public void getUser_test() {
        aopService04.getUser();
    }


    @Test
    public void getAdmin_test() {
        aopService04.getAdmin();
    }
}
