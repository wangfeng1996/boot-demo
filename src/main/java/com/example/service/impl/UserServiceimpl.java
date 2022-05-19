package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.UserRecordEvent;
import com.example.dao.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wf
 * @date 2022/4/18 09:45
 * @description
 */
@Service
public class UserServiceimpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void logInfo(UserRecordEvent userRecordEvent) {


    }


}
