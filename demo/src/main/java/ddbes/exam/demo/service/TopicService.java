package ddbes.exam.demo.service;

import ddbes.exam.demo.entity.Student;
import ddbes.exam.demo.entity.Topic;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.service
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 16:14
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */

public interface TopicService {
    //新增
    void saveTopic(Topic topic);
    //删除
    void removeTopic(String id);
    //修改
    void updateTopic(Topic topic);
    //根据编号修改
    Topic getById(String id);
    //查询所有
    List<Topic> listTopic();

}
