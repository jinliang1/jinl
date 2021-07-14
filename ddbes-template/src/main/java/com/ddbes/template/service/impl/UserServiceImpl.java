package com.ddbes.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddbes.template.entity.User;
import com.ddbes.template.mapper.UserMapper;
import com.ddbes.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ddbes-template
 * @Package: com.ddbes.template.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/6 15:18
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private  UserMapper userMapper;
    @Override
    public List<User> findAllUser() {
        List<User> allUser = userMapper.findAllUser();
        return  allUser;
    }
}
