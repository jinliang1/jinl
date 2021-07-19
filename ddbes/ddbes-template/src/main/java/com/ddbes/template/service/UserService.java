package com.ddbes.template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddbes.template.entity.User;

import java.util.List;

/**
 * @ProjectName: ddbes-template
 * @Package: com.ddbes.template.service
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/6 15:16
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
public interface UserService extends IService<User> {
    List<User> findAllUser();
}
