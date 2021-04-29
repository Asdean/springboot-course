package com.example.springexamples.example04.aopadvanced;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@MyAuthority
@Slf4j
public class AOPService04 {
    public void getUser() {

    }

    @MyAuthority(MyAuthority.MyAuthorityType.ADMIN)
    public void getAdmin() {

    }
}
