package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wf
 * @date 2022/4/18 09:38
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    void updateForUser(User user);


    List<User> listUser();

    User selectUserById(@Param("id") String id);

    void dynamicUpdate(User user);

    @Select("select * from tb_user where id =#{id}")
    List<User> selectUserWithAnnotation(String id);
}
