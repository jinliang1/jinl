package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.Test;
import ddbes.exam.demo.entity.TestPaper;
import ddbes.exam.demo.service.TestService;
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
 * @CreateDate: 2021/7/7 16:38
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "试卷得分")
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation("查看单个试卷考试情况")
    @GetMapping("/getTest/{uId}")
    public Result getTest(@PathVariable("uId") String uId){
        Test byId = testService.getById(uId);
        return Result.success(byId);
    }
    @ApiOperation("添加试卷得分情况")
    @PostMapping("/save")
    public  Result save(@RequestBody Test test){
        testService.save(test);
        return  Result.success();
    }
    @ApiOperation("查询全部")
    @GetMapping("/listAll")
    public Result listAll(){
        List<Test> testList = testService.list();
        return Result.success(testList);
    }



}
