package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.TestPaper;
import ddbes.exam.demo.entity.Topic;
import ddbes.exam.demo.service.TestPaperService;
import ddbes.exam.demo.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 15:50
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "试卷")
@RestController
public class TestPaperController {
    @Autowired
    private TestPaperService testPaperService;
    @Autowired
    private TopicService topicService;

    @ApiOperation("添加试卷")
    @PostMapping("/testPaper")
    public Result saveTestPaper(@RequestBody TestPaper testPaper) {
        long l = System.currentTimeMillis();
        if (l != testPaper.getTime()) {
            testPaper.setTime(l);
            List<Topic> topics = topicService.listTopic();
            testPaper.setListTopics(topics);
        }
        testPaperService.saveTestPaper(testPaper);
        return Result.success();
    }

    @ApiOperation("查询试卷")
    @GetMapping("/testPaper/{id}")
    public Result getTestPaper(@PathVariable("id") String id) {
        TestPaper testPaper = testPaperService.getTestPaper(id);
        return Result.success(testPaper);
    }
}
