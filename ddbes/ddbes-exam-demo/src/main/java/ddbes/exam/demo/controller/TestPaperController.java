package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.Question;
import ddbes.exam.demo.entity.TestPaper;
import ddbes.exam.demo.service.QuestionService;
import ddbes.exam.demo.service.TestPaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.rsa.RSACore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 16:16
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "考试试卷")
@RestController
@RequestMapping("/testPaper")
public class TestPaperController {
    @Autowired
    private TestPaperService testPaperService;
    @Autowired
    private QuestionService questionService;

    @ApiOperation("单个试卷提交")
    @GetMapping("/getTestPaper")
    public Result getTestPaper(@RequestBody Question question) {
        HashMap<String, String> map = new HashMap<>();
        Integer count;
        Integer sum;
        boolean b = questionService.saveQuestion(question);
        TestPaper testPaperByPaId = testPaperService.getTestPaperByPaId(question.getPaperId());
        List<Question> questionByPaId = questionService.getQuestionByPaId(question.getPaperId());
        List<Question> questions = questionService.listQuestons(question.getPaperId());
        for (int i = 0; i < questionByPaId.size(); i++) {
            if (!questionByPaId.get(i).getType().equals(4)) {
                map.put(questionByPaId.get(i).getId(), questionByPaId.get(i).getValue());
            }
        }

        for (String s : map.keySet()) {
            System.out.println("key  :" + s + "value  :" + map.get(s));
            for (int j = 0; j < questions.size(); j++) {
                if (map.get(s).equals(questions.get(j).getId())) {
                    //todo 判断是否包含答案
                    if (questions.get(j).getOption().indexOf(map.get(s)) != -1) {
                        int indexOf = questions.get(j).getOption().indexOf(map.get(s));
                        String substring = questions.get(j).getOption().substring(indexOf, 2);
                        count = Integer.parseInt(substring);
                        sum = count++;
                        testPaperByPaId.setScore(sum.toString());
                    }
                }
            }
        }
        return Result.success(testPaperByPaId);
    }

    @ApiOperation("创建试卷")
    @PostMapping("/save")
    public Result save(@RequestBody TestPaper testPaper) {
        testPaperService.saveTestPaper(testPaper);
        List<Question> questionByPaId = questionService
                .getQuestionByPaId(testPaper.getId());
        return Result.success(questionByPaId);
    }

}
