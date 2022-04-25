package com.example.listener;

import com.example.common.UserRecordEvent;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wangfeng
 * 用于项目启动时发现 也可以用@Service
 */
@Component
public class SearchReceive implements ApplicationListener<UserRecordEvent> {
    @Autowired
    private UserService userService;


    @Override
    public void onApplicationEvent(UserRecordEvent  userRecordEvent) {
        System.out.println("------------------");
    }
}