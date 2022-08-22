package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wf
 * @date 2022/8/22 10:56
 * @description stream流的测试
 */

@SpringBootTest(classes = BootDemoApplication.class)
@RunWith(SpringRunner.class)
public class StreamTest {

    /**
     * 将一个集合利用stream流转化成两个集合
     */
    @Test
    public void test01() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        Map<Boolean, List<Integer>> collect = arrayList.stream().
                collect(Collectors.groupingBy(result -> result > 2));
        List<Integer> integers = collect.get(true);
        List<Integer> integers1 = collect.get(false);
        System.out.println(integers);
        System.out.println(integers1);
    }

    @Test
    public void test02() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(result -> result > 2));
        // 大于2的数字
        System.out.println(map.get(true));
        // 小于2的数字
        System.out.println(map.get(false));
    }


}
