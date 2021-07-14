package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.TestPaper;
import ddbes.exam.demo.service.TestPaperService;
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
    @ApiOperation("查询单个试卷")
    @GetMapping("/getTestPaper/{uId}")
    public Result getTestPaper(@PathVariable("uId") String uId){
        TestPaper byId = testPaperService.getById(uId);
        return  Result.success(byId);
    }
    @ApiOperation("添加试卷")
    @PostMapping("/save")
    public  Result save(@RequestBody TestPaper testPaper){
        testPaperService.save(testPaper);
        return  Result.success();
    }
    @ApiOperation("查询全部")
    @GetMapping("/listAll")
    public Result listAll(){
        List<TestPaper> list = testPaperService.list();
        return Result.success(list);
    }
}
