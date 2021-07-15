package ddbes.exam.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ddbes.exam.demo.entity.Question;

import java.util.List;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 9:43
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
public interface QuestionService {
    List<Question> getQuestionByPaId(String paId);
    Question getQuestionByqId(String qId);
    boolean saveQuestion(Question question);
    boolean updateQuestion(Question question);
    boolean deleteQuestionByqId(String qId);
    List<Question> listQuestons(String paId);

}
