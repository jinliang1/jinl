package ddbes.exam.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.Question;
import ddbes.exam.demo.mapper.QuestionMapper;
import ddbes.exam.demo.service.QuestionService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 9:44
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
}
