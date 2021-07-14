package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.Question;
import ddbes.exam.demo.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 9:46
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "考题表")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @ApiOperation("查找单个考题")
    @GetMapping("/getQuestion/{qId}")
    public Result getQuestion(@PathVariable("qId") int qId){
        Question byId = questionService.getById(qId);
        return Result.success(byId);
    }
    @ApiOperation("查找全部")
    @GetMapping("/listQuestion")
    public Result listQuestion(){
        List<Question> list = questionService.list();
        return Result.success(list);
    }
    @ApiOperation("添加考题")
    @PostMapping("/save")
    public Result save(@RequestBody Question question){
        questionService.save(question);
        return Result.success();
    }
    @ApiOperation("修改考题")
    @PutMapping("/updateQuestion")
    public Result updateQuestion(@RequestBody Question question){
        questionService.updateById(question);
        return Result.success();
    }
    @ApiOperation("删除考题")
    @DeleteMapping("/deleteQuestion/{qId}")
    public Result deleteQuestion(@PathVariable("qId") int qId){
        questionService.removeById(qId);
        return Result.success();
    }
}
