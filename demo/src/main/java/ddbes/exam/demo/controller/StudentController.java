package ddbes.exam.demo.controller;

import com.ddbes.common.vo.Result;
import ddbes.exam.demo.entity.Student;
import ddbes.exam.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.controller
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/19 17:02
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Api(tags = "学生")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    //查询所有
    @ApiOperation("查询所有")
    @GetMapping("/students")
    public Result listStudent() {
        List<Student> studentList = studentService.listStudent();
        return Result.success(studentList);
    }

    //根据编号查询
    @ApiOperation("根据编号查询")
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable("id") String id) {
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    //根据编号删除
    @ApiOperation("根据编号删除")
    @DeleteMapping("/student/{id}")
    public Result removeStudent(@PathVariable("id") String id) {
        try {
            studentService.removeStudent(id);
            return new Result("200", "没有次id");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("500", "ok");
        }
    }
    @ApiOperation("修改")
    @PutMapping("students")
    public  Result updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.success(student);
    }

    @ApiOperation("增加")
    @PutMapping("student")
    public  Result saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return Result.success(student);
    }

    //多表联查
    @GetMapping("/findStudentAndGrade")
    public Result findStudentAndGrade(){
        Object studentAndGrade = studentService.getStudentAndGrade();
        return Result.success(studentAndGrade);
    }
}
