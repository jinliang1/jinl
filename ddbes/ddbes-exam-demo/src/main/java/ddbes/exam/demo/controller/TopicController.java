package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.Record;
import ddbes.exam.demo.entity.Topic;
import ddbes.exam.demo.service.RecordService;
import ddbes.exam.demo.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.statement.select.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/9 10:55
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "题集合")
@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private RecordService recordService;

    @ApiOperation("查询全部")
    @GetMapping("listTopic")
    public Result listTopic() {
        List<Topic> list = topicService.list();
        return Result.success(list);
    }

    @ApiOperation("添加")
    @PostMapping("/save")
    public Result saveList(@RequestBody Topic topic) {
        List<Record> list = recordService.list();
       /* Iterator<Record> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.hasNext());
        }*/
        topicService.save(topic);
        return Result.success();
    }


}
