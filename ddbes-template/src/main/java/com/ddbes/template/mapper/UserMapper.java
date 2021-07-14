package com.ddbes.template.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddbes.template.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: ddbes-template
 * @Package: com.ddbes.template.mapper
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/6 15:14
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> findAllUser();
}
