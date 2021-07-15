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
    @GetMapping("/getTestPaper/{paId}")
    public Result getTestPaper(@PathVariable("paId") String paId) {
        Integer count;
        Integer sum;
        TestPaper testPaperByPaId = testPaperService.getTestPaperByPaId(paId);
        List<Question> questionByPaId = questionService.getQuestionByPaId(paId);
        List<Question> questions = questionService.listQuestons(paId);
        for (int i = 0; i < questionByPaId.size(); i++) {
            for (int j = 0; j < questions.size(); j++) {
                if (questionByPaId.get(i).getQId().equals(questions.get(j).getQId())) {
                    if (!questionByPaId.get(i).getQType().equals(4)) {
                        //todo 判断是否包含答案
                        if (questions.get(j).getQOption().indexOf(questionByPaId.get(i).getQValue()) != -1) {
                            int indexOf = questions.get(j).getQOption().indexOf(questionByPaId.get(i).getQValue());
                            String substring = questions.get(j).getQOption().substring(indexOf, 2);
                            count = Integer.parseInt(substring);
                            sum = count++;
                            testPaperByPaId.setCourse(sum.toString());
                        }
                    }
                }
            }
        }
        return Result.success();
    }

    @ApiOperation("添加试卷")
    @PostMapping("/save")
    public Result save(@RequestBody TestPaper testPaper) {
        testPaperService.saveTestPaper(testPaper);
        List<Question> questionByPaId = questionService
                .getQuestionByPaId(testPaper.getPaId());
        return Result.success();
    }

}
