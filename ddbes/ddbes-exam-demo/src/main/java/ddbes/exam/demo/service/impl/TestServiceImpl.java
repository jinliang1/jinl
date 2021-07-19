package ddbes.exam.demo.service.impl;

import ch.qos.logback.core.boolex.EvaluationException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.Test;
import ddbes.exam.demo.mapper.TestMapper;
import ddbes.exam.demo.service.TestService;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 16:37
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
