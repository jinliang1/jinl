package ddbes.exam.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.UserFlag;
import ddbes.exam.demo.mapper.UserFlagMapper;
import ddbes.exam.demo.service.UserFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 8:34
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Service
public class UserFlagServiceImpl extends ServiceImpl<UserFlagMapper, UserFlag> implements UserFlagService {
    @Autowired
    private UserFlagMapper userFlagMapper;
    @Override
    public int save(String uId, String course, int flag) {
        return userFlagMapper.save(uId,course,flag);
    }
}
