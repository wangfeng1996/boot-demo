package com.example;

import com.example.dao.UserMapper;
import com.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wf
 * @date 2022/8/24 10:01
 * @description
 */
@SpringBootTest(classes = BootDemoApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser() {
        User user = new User();
        user.setUserName("lisi");
        user.setAddress("南京");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId("1562259455637319682");
        user.setUserName("wangwu");
        user.setAddress("北京");
        userMapper.updateForUser(user);
    }

    @Test
    public void selectUser() {
        List<User> users = userMapper.listUser();
        System.out.println(users);
    }

    @Test
    public void selectUserById() {
        User user = userMapper.selectUserById("1562265168656760834");
        System.out.println(user);
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void dynamicUpdate() {
        User user = new User();
        user.setId("1562265168656760834");
        user.setUserName("赵六");
        userMapper.dynamicUpdate(user);
    }

    @Test
    public void selectWithAnnotation() {
        List<User> users = userMapper.selectUserWithAnnotation("1562265168656760834");
        System.out.println(users.get(0));
    }


}
