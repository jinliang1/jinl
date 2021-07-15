package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.TestSet;
import ddbes.exam.demo.service.TestSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 9:23
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "考试设计")
@RestController
@RequestMapping("/testSet")
public class TestSetController {
    @Autowired
    private TestSetService testSetService;

    @ApiOperation("查找科目")
    @GetMapping("/getCourse/{course}")
    private Result getCourse(@PathVariable("course") String course) {
        TestSet byId = testSetService.getById(course);
        return Result.success(byId);
    }

    @ApiOperation("保存考试设计")
    @PostMapping("/save")
    private Result save(@RequestBody TestSet testSet) {
        testSetService.save(testSet);
        return Result.success();
    }
}
