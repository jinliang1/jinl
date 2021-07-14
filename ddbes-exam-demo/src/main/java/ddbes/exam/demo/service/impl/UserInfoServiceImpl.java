package ddbes.exam.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.UserInfo;
import ddbes.exam.demo.mapper.UserInfoMapper;
import ddbes.exam.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 10:28
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
