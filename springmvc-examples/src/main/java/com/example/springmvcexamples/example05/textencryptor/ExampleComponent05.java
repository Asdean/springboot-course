package com.example.springmvcexamples.example05.textencryptor;

import com.example.springmvcexamples.example02.exception.MyException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExampleComponent05 {
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${my.secretkey}")
    private String secretKey;
    @Value("${my.salt}")
    private String salt;

    @Autowired
    // 注入getTextEncryptor()方法创建的对象
    private TextEncryptor encryptor;

    /**
     * 直接基于密钥/盐值创建单例TextEncryptor对象。避免反复创建
     *
     * TextEncryptor Encryptors.text(secretKey, salt)
     * 基于指定密钥/盐值创建文本加密器
     *
     * @return
     */
    @Bean
    public TextEncryptor getTextEncryptor() {
        return Encryptors.text(secretKey, salt);
    }

    public String encrypt(Map<String, Object> payload) {
        try {
            String json = objectMapper.writeValueAsString(payload);
            return encryptor.encrypt(json);
        } catch (JsonProcessingException e) {
            throw new MyException(500, "服务端错误");
        }
    }

    /**
     * 无法验证/解密/反序列化，说明数据被篡改，无权限
     * @param auth
     * @return
     */
    public Map<String, Object> decrypt(String auth) {
        try {
            String json = encryptor.decrypt(auth);
            return objectMapper.readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            throw new MyException(403, "无权限");
        }
    }
}
