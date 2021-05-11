package com.example.springexamples.example05;

import com.example.springexamples.example05.transactions.entity.User05;
import com.example.springexamples.example05.transactions.service.UserService05;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
public class UserService05Test {
    @Autowired
    private UserService05 userService05;

    /*@Test
    public void test() {
        User05 user = User05.builder().id(79L).name("SUN").build();
        userService05.addUser(user);    //插入成功
    }*/
    /*@Test
    public void test() {
        User05 user = User05.builder().id(80L).name("SUN").build();
        try {
            userService05.addUser(user);
        } catch (IOException e) {
            e.printStackTrace();    //插入成功
        }
    }*/
    @Test
    public void test() {
        User05 user = User05.builder().id(81L).name("SUN").build();
        userService05.addUser(user);    //插入成功
    }
}
