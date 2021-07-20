package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.Grade;
import ddbes.exam.demo.entity.Student;
import ddbes.exam.demo.service.GradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 9:31
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "年级")
@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    public Result findAll(){
        List<Grade> listGrades = gradeService.listGrades();
        return Result.success(listGrades);
    }
    @ApiOperation("查询单个")
    @GetMapping("/findOne/{id}")
    public Result findOne(@PathVariable("id") String id){
        Grade byId = gradeService.getById(id);
        return Result.success(byId);
    }

    @ApiOperation("根据编号删除")
    @DeleteMapping("/grade/{id}")
    public Result removeGrade(@PathVariable("id") String id){
        try {
            gradeService.removeGrade(id);
            return new Result("200","");
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result("500" , "");
        }
    }


    @ApiOperation("修改")
    @PutMapping("/grade")
    public Result updateGrade(@RequestBody Grade grade){
        gradeService.updateGrade(grade);
        return Result.success(grade);
    }

    @ApiOperation("添加")
    @PostMapping("/grade")
    public Result saveGrade(@RequestBody Grade grade){
        gradeService.saveGrade(grade);
        return Result.success(grade);
    }




}
