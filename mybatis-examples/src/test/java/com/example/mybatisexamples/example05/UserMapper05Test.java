package com.example.mybatisexamples.example05;

import com.example.mybatisexamples.entity.Address;
import com.example.mybatisexamples.entity.User;
import com.example.mybatisexamples.mapper.AddressMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
public class UserMapper05Test {
    @Autowired
    private UserMapper05 userMapper05;
    @Autowired
    private AddressMapper05 addressMapper05;

    @Test
    public void getById_test() {
        UserDTO05 u = userMapper05.getById(2L);
        log.debug("{}/{}", u.getName(), u.getCompany());
        for (Address a : u.getAddresses()) {
            log.debug("{}/{}", a.getDetail(), a.getCreateTime());
        }
    }

    @Test
    public void getById_test2() {
        Long uid = 2L;
        User user = userMapper05.selectById(uid);
        List<Address> addresses = addressMapper05.selectByMap(Map.of("user_id", uid));
        UserDTO05 userDTO05 = new UserDTO05();
        BeanUtils.copyProperties(user,userDTO05);
        userDTO05.setAddresses(addresses);
        log.debug("{}/{}", userDTO05.getName(), userDTO05.getCompany());
        for (Address a : userDTO05.getAddresses()) {
            log.debug("{}/{}", a.getDetail(), a.getCreateTime());
        }
    }

    @Test
    public void getById_test3() {
        UserDTO05 userDTO = userMapper05.getByXML(2L);
        log.debug("{}/{}",userDTO.getName(),userDTO.getCompany());
        for (Address a : userDTO.getAddresses()) {
            log.debug("{}/{}",a.getDetail() ,a.getCreateTime());
        }
    }

    @Test
    public void getById_test4() {
        UserDTO05 userDTO = userMapper05.getByXML(2L);
        log.debug("{}/{}",userDTO.getName(),userDTO.getCompany());
        for (Address a : userDTO.getAddresses()) {
            log.debug("{}/{}",a.getDetail() ,a.getCreateTime());
        }
    }
}
