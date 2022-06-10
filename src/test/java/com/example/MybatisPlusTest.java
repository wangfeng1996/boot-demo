package com.example;

import com.alibaba.fastjson.JSON;
import com.example.pojo.TraceBack;
import com.example.pojo.User;
import com.example.service.TraceBackService;
import com.example.service.impl.UserServiceimpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wf
 * @date 2022/5/19 15:54
 * @description
 */
@SpringBootTest(classes = BootDemoApplication.class)
@RunWith(SpringRunner.class)
public class MybatisPlusTest {
    @Autowired
    private UserServiceimpl userServiceimpl;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("张三");
        user.setAddress("江苏南京");
        userServiceimpl.save(user);
    }

    @Test
    public void testSaveOrUpdate() {
        User user = new User();
        user.setId("1527198749623885821");
        user.setUserName("lisi");
        user.setAddress("lisi");
        userServiceimpl.saveOrUpdate(user);

    }

    @Test
    public void testCount() {
        //int count = userServiceimpl.count();
        //System.out.println(count);
    }

    @Test
    public void testChain() {
        //new LambdaQueryWrapper<>()
    }

    @Autowired
    private TraceBackService traceBackService;

    @Test
    public void test() {
        List<TraceBack> sheetId = traceBackService.getSheetId("5");
        System.out.println(sheetId);
    }

    @Test
    public void limitTest() {
        List<Object> collect = userServiceimpl.list().stream().map(user -> user.getId()).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void filterElement() {
        List<User> userList = userServiceimpl.list().stream().
                filter((user -> (!user.getUserName().equals("lisi") || !user.getUserName().equals("李四")))).collect(Collectors.toList());
        System.out.println(userList);
    }

    @org.junit.Test
    public void jsontest() {
        List<User> list = userServiceimpl.list();
        Object json = JSON.toJSON(list);
        System.out.println(json);
    }

}
