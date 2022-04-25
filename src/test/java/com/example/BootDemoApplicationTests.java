package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.dao.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = BootDemoApplication.class)
@RunWith(SpringRunner.class)
class BootDemoApplicationTests {
    @Autowired
    private UserService userService;


    @Test
    void contextLoads() {

        System.out.println("Hello World");
    }


    @Test
    void test1() {

        //Page<User> page = new Page<>(0, 10);
        //OrderItem orderItem = OrderItem.asc("id");
        ////page.addOrder(orderItem);
        //LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //wrapper.orderByAsc(User::getId);
        //userService.page(page, wrapper);
        //////List<User> records = userService.page(page).getRecords();
        //////System.out.println(records);
        ////
        //////SELECT id, username, address FROM tb_user ORDER BY id ASC LIMIT ?
        //
        //Map<String, Object> collect = userService.list().stream().collect(Collectors.toMap(User::getId, User::getUsername));
        //System.out.println(collect);
        //
        //Optional.ofNullable(userService.getById(1)).ifPresent(System.out::println);


    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    @Cacheable(key = "'id:'+#id")
    public void test02() {
        User user = userService.getById(1515868416959348737L);
        System.out.println(user);
    }

    @Test
    public void updateTest() {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        List<User> list = userService.list();
        ModelAndView modelAndView = new ModelAndView(new JeecgEntityExcelView());
        modelAndView.addObject(NormalExcelConstants.FILE_NAME, "用户信息");
        // 注解对象class对象
        modelAndView.addObject(NormalExcelConstants.CLASS, User.class);
        modelAndView.addObject(NormalExcelConstants.PARAMS, new ExportParams());
        modelAndView.addObject(NormalExcelConstants.DATA_LIST, list);
    }

    @Test
    public void pairTest() {
        Pair<String, String> pair = Pair.of("a", "b");
        String left = pair.getLeft();
        String right = pair.getRight();
        String value = pair.getValue();
        System.out.println(left);
        System.out.println(right);
        System.out.println(value);
        String key = pair.getKey();
        System.out.println(key);
    }

    @Test
    public void eventTest() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("张三" + "," + i);
            user.setAddress("beijing" + "," + i);
            userService.save(user);
        }
    }

    @Test
    public void streamTest() {
        //List<User> list = userService.list();
        ////Map<String, User> map = list.stream().collect(Collectors.toMap(User::getId, user -> user));
        ////System.out.println(map);
        //
        //Set<String> idList = list.stream().map(User::getId).collect(Collectors.toSet());
        //
        //
        //boolean result = list.stream().anyMatch(user -> !idList.contains(user.getId()));
        //System.out.println(result);

        String hello = StringUtils.trimToNull("hello   world");
        System.out.println(hello);
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser() {

        User user = new User();
        //user.setId("");
        user.setUserName("12345");
        user.setAddress("123456");
        userMapper.insert(user);
    }

    @Test
    public void updateBatch() {

        List<String> list = userService.list().stream().map(User::getId).collect(Collectors.toList());

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(User::getUserName,"李四").eq(User::getAddress,"beijing,2").in(User::getId,list);
        List<User> userList = userService.list(queryWrapper);
        System.out.println(userList);


       // LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
       //
       //wrapper.eq(User::getUserName,"李四").set(User::getUserName,"王武").in(User::getId,list);
       // userService.update(wrapper);
    }

}
