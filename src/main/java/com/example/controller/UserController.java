package com.example.controller;


import com.example.dao.UserMapper;
import com.example.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author wf
 * @date 2022/4/18 09:33
 * @description
 */
@RestController
@RequestMapping
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls() {
        log.info("导出厂外人员信息");
        //组建查询条件
        //QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> userList = userMapper.selectList(null);
        ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
        //导出文件名称
        mv.addObject(NormalExcelConstants.FILE_NAME, "用户信息");
        //注解对象Class
        mv.addObject(NormalExcelConstants.CLASS, User.class);
        //自定义导出字段
        mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("用户信息表", "导出人:wf", "导出信息"));
        //导出数据列表
        mv.addObject(NormalExcelConstants.DATA_LIST, userList);
        return mv;
    }
}


