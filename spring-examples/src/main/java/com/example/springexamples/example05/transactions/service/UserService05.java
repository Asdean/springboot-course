package com.example.springexamples.example05.transactions.service;

import com.example.springexamples.example05.transactions.entity.User05;
import com.example.springexamples.example05.transactions.mapper.UserMapper05;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*@Service
@Transactional
public class UserService05 {
    @Autowired
    private UserMapper05 userMapper05;

    public void addUser(User05 user) {
        userMapper05.insert(user);

        //报异常，但是数据插入数据库成功，未开启事务回滚
        try {
            Files.readString(Path.of("A:/aa.aa"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
/*@Service
@Transactional
public class UserService05 {
    @Autowired
    private UserMapper05 userMapper05;

    public void addUser(User05 user) throws IOException {
        userMapper05.insert(user);

        //报异常，但是数据插入数据库成功，未开启事务回滚
        Files.readString(Path.of("A:/aa.aa"));
    }
}*/
@Service
@Transactional
public class UserService05 {
    @Autowired
    private UserMapper05 userMapper05;

    public void addUser(User05 user) {
        userMapper05.insert(user);

        //报异常，但是数据插入数据库成功，未开启事务回滚
        try {
            Files.readString(Path.of("A:/aa.aa"));
        } catch (IOException e) {
            //转抛出非受检异常，插入失败，
            // 虽然显式数据插入操作执行成功但由于异常操作致使插入的数据回滚
            throw new RuntimeException("操作错误");
        }
    }
}