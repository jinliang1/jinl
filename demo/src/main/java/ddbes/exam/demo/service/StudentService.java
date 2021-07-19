package ddbes.exam.demo.service;

import ddbes.exam.demo.entity.Student;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.service
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/19 16:34
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
public interface  StudentService {
    //新增
    void saveStudent(Student student);
    //删除
    void removeStudent(String id);
    //修改
    void updateStudent(Student student);
    //根据编号修改
    Student getById(String id);
    //查询所有
    List<Student> listStudent();

    //两表联查
    Object getStudentAndGrade();
}
