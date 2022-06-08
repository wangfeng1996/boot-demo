package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.UserRecordEvent;
import com.example.pojo.User;

/**
 * @author wf
 * @date 2022/4/18 09:45
 * @description
 */
public interface UserService extends IService<User> {
    void logInfo(UserRecordEvent userRecordEvent);

}
