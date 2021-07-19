package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.Test;
import ddbes.exam.demo.entity.TestPaper;
import ddbes.exam.demo.entity.UserFlag;
import ddbes.exam.demo.entity.UserInfo;
import ddbes.exam.demo.service.TestPaperService;
import ddbes.exam.demo.service.TestService;
import ddbes.exam.demo.service.UserFlagService;
import ddbes.exam.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 14:38
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "事务处理")
@RestController
@RequestMapping("/routine")
@Slf4j
public class RoutineController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestPaperService testPaperService;
    @Autowired
    private UserFlagService userFlagService;

    /* @Autowired
    private UserInfoService userInfoService;*/
    @ApiOperation("关于id的事务处理")
    @Transactional
    @PostMapping("/save/")
    private Result save(@RequestBody TestPaper paper) {
        testPaperService.saveTestPaper(paper);
        return Result.success();
    }


}
