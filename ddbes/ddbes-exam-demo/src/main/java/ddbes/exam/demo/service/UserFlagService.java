package ddbes.exam.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ddbes.exam.demo.entity.UserFlag;
import ddbes.exam.demo.mapper.UserFlagMapper;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 8:33
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
public interface UserFlagService extends IService<UserFlag> {
    int save(String uId, String course,int flag);
}
