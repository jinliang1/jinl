package ddbes.exam.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.TestSet;
import ddbes.exam.demo.mapper.TestSetMapper;
import ddbes.exam.demo.service.TestSetService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 9:21
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Service
public class TestSetServiceImpl extends ServiceImpl<TestSetMapper, TestSet> implements TestSetService {
}
