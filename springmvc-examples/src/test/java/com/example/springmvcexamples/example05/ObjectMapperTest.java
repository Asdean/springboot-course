package com.example.springmvcexamples.example05;

import com.example.springmvcexamples.example04.passwordencoder.entity.User04;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
public class ObjectMapperTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    /**
     * SpringMVC默认基于Jackson实现序列化/反序列化
     * SpringMVC自动注入Jackson ObjectMapper映射对象到容器
     * String writeValueAsString(T payload)，将对象序列化为json字符串
     * T readValue(String content, Class c)，将json字符串反序列化为指定类型的Java对象
     */
    public void test_mapper() {
        User04 u = new User04();
        u.setUserName("BO");
        u.setPassword("123456");
        try {
            String json = objectMapper.writeValueAsString(u);
            log.debug(json);
            User04 user04 = objectMapper.readValue(json, User04.class);
            log.debug(user04.getUserName());
            log.debug(user04.getPassword());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 无法直接反序列化带泛型的类型
     * TypeReference<T>抽象类。创建子类，具体化泛型。可通过创建类似接口的匿名内部类实现
     */
    public void test_mapper2() {
        User04 u = new User04();
        u.setUserName("BO");
        u.setPassword("123456");
        Map<String, User04> map = Map.of("user", u);
        try {
            String json = objectMapper.writeValueAsString(map);
            log.debug(json);
            Map<String, User04> user04Map = objectMapper.readValue(json, new TypeReference<Map<String, User04>>() {});
            user04Map.forEach((k, v) -> {
                log.debug(k);
                log.debug(v.getUserName() + "/" + v.getPassword());
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
