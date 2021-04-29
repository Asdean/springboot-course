package com.example.mybatisexamples.example05;

import com.example.mybatisexamples.example04.AddressMapper04;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AddressMapper05Test {
    @Autowired
    private AddressMapper05 addressMapper05;

    @Test
    public void getAddress_list_test() {
        for (AddressDTO05 addressDTO05 : addressMapper05.listAddressDTOs("1201")) {
            log.debug("{}/{}/{}/{}/{}", addressDTO05.getId(), addressDTO05.getCreateTime(), addressDTO05.getDetail(), addressDTO05.getUser().getName(), addressDTO05.getUser().getCreateTime());
        }
    }
}
