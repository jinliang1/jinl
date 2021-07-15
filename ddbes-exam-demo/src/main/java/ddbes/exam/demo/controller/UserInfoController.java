package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.UserInfo;
import ddbes.exam.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 10:30
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "考试用户")
@Slf4j
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    /**
     * 根据id查找
     */

    @ApiOperation("根据id查找")
    @GetMapping("/getUser/{uId}")
    public Result getUser(@PathVariable("uId")  String uId){
        UserInfo byId = userInfoService.getById(uId);
        return Result.success(byId);
    }
    /**
     * 查询全部
     */
    @ApiOperation("查找全部")
    @GetMapping("/listUser")
    public Result listUser(){
        List<UserInfo> userInfoList = userInfoService.list();
        return Result.success(userInfoList);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    public Result save(@RequestBody UserInfo userInfo){
        userInfoService.save(userInfo);
        return Result.success();
    }
    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping("/update")
    public Result update(@RequestBody UserInfo userInfo) {
       userInfoService.updateById(userInfo);
        return Result.success();
    }
    /**
     * 删除
     */
    @ApiOperation("删除")
    @DeleteMapping("/delete/{uId}")
    public  Result delete(@PathVariable("uId")  String uId){
        userInfoService.removeById(uId);
        return Result.success();
    }



}
