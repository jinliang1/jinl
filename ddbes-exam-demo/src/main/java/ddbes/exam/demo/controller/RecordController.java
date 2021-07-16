package ddbes.exam.demo.controller;

import com.baomidou.mybatisplus.extension.service.additional.update.impl.UpdateChainWrapper;
import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.Record;
import ddbes.exam.demo.entity.TestPaper;
import ddbes.exam.demo.mapper.RecordMapper;
import ddbes.exam.demo.service.RecordService;
import ddbes.exam.demo.service.TestPaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.SimpleFormatter;

import ddbes.exam.demo.utils.Time;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/14 13:37
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "人员考试记录表")
@RequestMapping("/record")
@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private TestPaperService testPaperService;

    @ApiOperation("添加记录")
    @PostMapping("/save")
    public Result save(@RequestBody Record record) {
        //todo 添加记录
        long startTime = System.currentTimeMillis();
        recordService.saveRecord(record.getRId(),record.getUId(), record.getPaId(), startTime, "0");
        Record getOne = recordService.getRecord(record.getPaId());
        return Result.success(getOne);
    }

    @ApiOperation("更新记录")
    @PutMapping("/update")
    public Result update(@RequestBody Record record) {
        //todo 更新记录
        long comTime = System.currentTimeMillis();//提交后时间
        long sum;
        TestPaper testPaperByPaId = testPaperService.getTestPaperByPaId(record.getPaId());
        Record getOne = recordService.getRecord(record.getPaId());
        sum = getOne.getStartTime() + testPaperByPaId.getTime();
        if (sum > comTime) {
            recordService.updateRecord(testPaperByPaId.getScore(), comTime, "2", record.getRId());
        } else {
            recordService.updateRecord(testPaperByPaId.getScore(), comTime, "1", record.getRId());
        }
        return Result.success();
    }

}
