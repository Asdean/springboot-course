package com.example.mybatisexamples.example02;

import com.example.mybatisexamples.entity.User;
import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class UserMapper02Test {
    @Autowired
    private UserMapper02 userMapper02;

    @Test
    public void addUser_test() {
        User user = new User();
        user.setName("SUN");
        user.setCompany("amazon");
        userMapper02.insert(user);
    }

    @Test
    public void update_test() {
        User user = User.builder()
                .id(1381794973552111617L)
                .company("nike")
                .build();
        userMapper02.updateById(user);
    }

    @Test
    public void list_test() {
        List<User> users = userMapper02.selectByMap(Map.of("company","nike"));
        for (User user : users) {
            log.debug("{}/{}/{}",user.getId(),user.getName(),user.getCompany());
        }
    }

    @Test
    public void list_test2() {
        List<User> users = userMapper02.listBycompany("nike");
        for (User user : users) {
            log.debug("{}/{}",user.getId(),user.getName());
        }
    }
}
