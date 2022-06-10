package com.example;

/**
 * @author wf
 * @date 2022/6/9 09:35
 * @description
 */

import com.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest(classes = BootDemoApplication.class)
@RunWith(SpringRunner.class)
public class MiDoTest {


    @Test
    public void listTest() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        ArrayList list = new ArrayList<>(list1);
        System.out.println(list);
        User user = new User();
        User hello = user.setUserName("hello");

    }
}
