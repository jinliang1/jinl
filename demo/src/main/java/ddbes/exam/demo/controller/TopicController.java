package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.Topic;
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
 * @CreateDate: 2021/7/20 16:25
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "题")
@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @ApiOperation("添加题")
    @PostMapping("/saveTopic")
    public Result saveTopic(@RequestBody Topic topic){
        topicService.saveTopic(topic);
        return  Result.success();
    }
    @ApiOperation("查看单个试题")
    @GetMapping("/getTopic/{id}")
    public  Result getTopic(@PathVariable("id") String id){
        Topic byId = topicService.getById(id);
        return Result.success(byId);
    }

    @ApiOperation("查看全部题")
    @GetMapping("/listTopic")
    public  Result listTopic(){
        List<Topic> topics = topicService.listTopic();
        return Result.success(topics);
    }
}
