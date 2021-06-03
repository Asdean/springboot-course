package com.example.springmvcexamples.example05;

import com.example.springmvcexamples.example05.textencryptor.ExampleComponent05;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
public class TextEncryptTest {
    @Autowired
    private ExampleComponent05 encrypt;

    @Test
    public void test_encrypt() {
        Map<String, Object> map = Map.of("uid", 1384896304762638307L, "role", 9);
        String r = encrypt.encrypt(map);
        log.debug(r);
        log.debug("{}", r.length());
        log.debug(encrypt.encrypt(map));
    }

    @Test
    public void test_decrypt() {
        String auth = "98454a6e7cb11d1152fb510a02a0056f2b2e94254a6c9f5a84" +
                "16cca2da0a7ed75919220ecdaf57948af317cf00a5e5d3c6984e5a3a390f345de44673d89ca46c";
        Map<String, Object> map = encrypt.decrypt(auth);
        log.debug("{}", map.get("uid"));
        log.debug("{}", map.get("role"));
    }
}
