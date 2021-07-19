package com.ddbes.template.controller;

import com.ddbes.common.feign.IdServiceFeign;
import com.ddbes.common.vo.Result;
import com.ddbes.template.entity.User;
import com.ddbes.template.service.UserService;
import com.sun.deploy.security.BadCertificateDialog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: ddbes-template
 * @Package: com.ddbes.template.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/6 15:20
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "用户测试")
@Slf4j
@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
  /*  @Autowired
    private IdServiceFeign idServiceFeign;*/

    /**
     * 根据id查找
     */
    @GetMapping("/findOne/{id}")
    @ApiOperation("根据id查找")
    public Result findOne(@PathVariable("id") Integer id){
        User byId = userService.getById(id);
        return Result.success(byId);
    }
    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("保存")
    public Result save(@RequestBody User user){
        //这里的id是String类型的
        //user.setId(idServiceFeign.getId());
        userService.save(user);
        return Result.success();
    }
    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("修改")
    public Result update(@RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public  Result delete(@PathVariable("id") String id){
        userService.removeById(id);
        return Result.success();
    }
    /**
     * 查询全部
     */
    @GetMapping("/findall")
    @ApiOperation("查询全部")
    public Result findall(){
        //List<User> allUser = userService.findAllUser();
        List<User> list = userService.list();
        return   Result.success(list);
    }
    @GetMapping
    @ApiOperation("查询全部")
    public  Result find(){
        List<User> allUser = userService.findAllUser();
        return  Result.success(allUser);
    }

}
