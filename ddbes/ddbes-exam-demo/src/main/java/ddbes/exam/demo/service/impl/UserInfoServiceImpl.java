package ddbes.exam.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.UserInfo;
import ddbes.exam.demo.mapper.UserInfoMapper;
import ddbes.exam.demo.service.UserInfoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

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
    //todo 分页查询
    public IPage selectPage(IPage<UserInfo> page, QueryWrapper<UserInfo> wrapper){
        return baseMapper.selectPage(page,wrapper);
    }
}
