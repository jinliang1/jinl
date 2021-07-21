package ddbes.exam.demo.service;

import ddbes.exam.demo.entity.Student;
import ddbes.exam.demo.entity.TestPaper;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.service
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 15:42
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
public interface TestPaperService {
    //新增
    void saveTestPaper(TestPaper testPaper);

    //删除
    void removeTestPaper(String id);

    //修改
    void updateTestPaper(TestPaper testPaper);

    //根据编号修改
    TestPaper getById(String id);

    //查询整张试卷
   TestPaper getTestPaper(String id);

}
