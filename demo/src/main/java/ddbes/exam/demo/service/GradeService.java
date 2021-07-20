package ddbes.exam.demo.service;

import ddbes.exam.demo.entity.Grade;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.service
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 9:14
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
public interface GradeService {
    //新增
    void saveGrade(Grade grade);
    //删除
    void removeGrade(String id);
    //修改
    void updateGrade(Grade grade);
    //根据编号修改
    Grade getById(String id);
    //查询所有
    List<Grade> listGrades();
}
