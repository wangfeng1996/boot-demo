package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author wf
 * @date 2022/5/7 09:41
 * @description
 */
@SpringBootTest(classes = BootDemoApplication.class)
@RunWith(SpringRunner.class)
public class NewFeaturesTests {
    @Value("${com.ymx.demo}")
    private String url;

    @Test
    public void nullJudge() {
        System.out.println(url);
    }
}
