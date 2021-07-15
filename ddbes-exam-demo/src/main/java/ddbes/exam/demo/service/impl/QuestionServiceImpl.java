package ddbes.exam.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.Question;
import ddbes.exam.demo.mapper.QuestionMapper;
import ddbes.exam.demo.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public List<Question> getQuestionByPaId(String paId) {
        return list(new QueryWrapper<Question>().lambda()
                .eq(Question::getPaId, paId));
    }

    @Override
    public Question getQuestionByqId(String qId) {
        return getOne(new QueryWrapper<Question>().lambda()
        .eq(Question::getQId,qId));
    }

    @Override
    public boolean saveQuestion(Question question) {
        return save(question);
    }

    @Override
    public boolean updateQuestion(Question question) {
        return updateById(question);
    }

    @Override
    public boolean deleteQuestionByqId(String qId) {
        return remove(new QueryWrapper<Question>().lambda()
        .eq(Question::getQId,qId));

    }

    @Override
    public List<Question> listQuestons(String paId) {
        return list(new QueryWrapper<Question>().lambda()
                .eq(Question::getPaId, paId));
    }




}
