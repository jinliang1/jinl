package ddbes.exam.demo.service.impl;

import ddbes.exam.demo.entity.Topic;
import ddbes.exam.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 16:16
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Component
public class TopicServiceImpl implements TopicService {
    @Autowired
    private MongoTemplate mongoTemplate;

    // 添加
    @Override
    public void saveTopic(Topic topic) {
        Topic save = mongoTemplate.save(topic);

    }

    // todo 通过id删除
    @Override
    public void removeTopic(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Topic.class);

    }

    @Override
    public void updateTopic(Topic topic) {

    }

    // todo 查询单个试题
    @Override
    public Topic getById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Topic one = mongoTemplate.findOne(query, Topic.class);
        return one;
    }

    //todo 查看所有题
    @Override
    public List<Topic> listTopic() {
        return mongoTemplate.findAll(Topic.class);
    }
}
