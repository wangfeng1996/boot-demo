package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wf
 * @date 2022/4/18 09:38
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {



}
