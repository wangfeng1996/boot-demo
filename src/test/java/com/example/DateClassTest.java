package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wf
 * @date 2022/8/19 10:14
 * @description 时间类 Calendar 时间类的测试
 */
@SpringBootTest(classes = BootDemoApplication.class)
@RunWith(SpringRunner.class)
public class DateClassTest {
    /**
     * 测试1
     */
    @Test
    public void test_01() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 0);
        // 每月的第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 每天的0时
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        // 每天的0分
        calendar.set(Calendar.MINUTE, 0);
        // 每天的0秒
        calendar.set(Calendar.SECOND, 0);
        // 获取每月的第一天的时间
        System.out.println(calendar.getTime());
    }

    /**
     * 判断每年的月份一共有多少天
     */
    @Test
    public void Test_02() {
        Calendar instance = Calendar.getInstance();
        //int year = 2021;
        //int month = 5;
        //
        //instance.set(Calendar.YEAR, year);
        //instance.set(Calendar.MONTH, month-1);
        //int maximum = instance.getActualMaximum(4);
        int RESULT = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(RESULT);
        System.out.println(instance.getTime());

    }

}
