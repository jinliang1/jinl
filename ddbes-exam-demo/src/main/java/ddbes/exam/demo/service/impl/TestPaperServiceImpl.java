package ddbes.exam.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.TestPaper;
import ddbes.exam.demo.mapper.TestPaperMapper;
import ddbes.exam.demo.service.TestPaperService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 16:13
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Service
public class TestPaperServiceImpl extends ServiceImpl<TestPaperMapper, TestPaper> implements TestPaperService {
    @Override
    public TestPaper getTestPaperByPaId(String paId) {
        return getOne(new QueryWrapper<TestPaper>().lambda()
                .eq(TestPaper::getPaId, paId));
    }

    @Override
    public boolean saveTestPaper( TestPaper testPaper) {
        return save(testPaper);
    }


}
