package com.example.mybatisexamples.example06;

import com.example.mybatisexamples.entity.GithubUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class GithubUserMapper06Test {
    @Autowired
    private GithubUserMapper06 githubUserMapper06;

    @Test
    public void querywrapper_test() {
        /**
         * 模拟的查询条件
         * 条件数据为动态，不确定用户选择输入了那些条件数据
         */
        QueryOptional optionals = QueryOptional.builder()
                .stars(18)
                .repos(18)
                .followers(24)
                .beforeCreateTime(LocalDateTime.of(2021, 5, 15, 16, 52))
                .build();
        for (GithubUser g : githubUserMapper06.listByOptionals(optionals)) {
            log.debug("{}",g.getName());
        }
    }

    /**
     * 调用xml中声明的动态查询
     */
    @Test
    public void querywrapper_xml_test() {
        QueryOptional optionals = QueryOptional.builder()
                .repos(10)
                .beforeCreateTime(LocalDateTime.of(2021, 5, 15, 16, 52))
                .build();
        for (GithubUser g : githubUserMapper06.listByOptionals2(optionals)) {
            log.debug("{}",g.getName());
        }
    }
}
