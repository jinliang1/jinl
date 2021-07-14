package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.Exception.DefaultExceptionAdvice;
import ddbes.exam.demo.entity.UserFlag;
import ddbes.exam.demo.service.UserFlagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import ddbes.exam.demo.Exception.DefaultExceptionAdvice;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 8:40
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "用户标记")
@RestController
@Slf4j
@RequestMapping("/userFlag")
public class UserFlagController {
    @Autowired
    private UserFlagService userFlagService;

    @ApiOperation("根据id查找当前用户状态")
    @GetMapping("/getById/{uId}")
    public Result getById(@PathVariable("uId") String uId){
        UserFlag byId = userFlagService.getById(uId);
        return  Result.success(byId);
    }
    @ApiOperation("查询全部")
    @GetMapping("/listUserFlag")
    private  Result listUserFlag(){
        List<UserFlag> userFlagList = userFlagService.list();
        return Result.success(userFlagList);
    }
    @ApiOperation("添加用户标记")
    @PostMapping("/save")
    private Result save(@RequestBody @Valid UserFlag userFlag,MethodArgumentNotValidException e){
        try {
            if (userFlag!=null){
               userFlagService.save(userFlag);
            } else {
                String errorMessage = e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                        .collect(Collectors.joining(","));
                log.error("属性字段校验异常：{}", errorMessage);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return Result.success(userFlag);
    }
    @ApiOperation("删除")
    @DeleteMapping("/delete/{uId}")
    private Result delete(@PathVariable("uId") String uId){
        userFlagService.removeById(uId);
        return Result.success();
    }
    @ApiOperation("添加用户标记2")
    @PostMapping("/save2")
    private Result save(String uId,String course, int flag){
        userFlagService.save(uId,course,flag);
        return Result.success();
    }

}
