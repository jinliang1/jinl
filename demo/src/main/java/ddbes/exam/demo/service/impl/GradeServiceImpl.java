package ddbes.exam.demo.service.impl;

import ddbes.exam.demo.entity.Grade;
import ddbes.exam.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 9:14
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Component
public class GradeServiceImpl implements GradeService {
    @Autowired
    private MongoTemplate mongoTemplate;
    //todo 添加
    @Override
    public void saveGrade(Grade grade) {
        mongoTemplate.save(grade);
    }
    // todo 删除
    @Override
    public void removeGrade(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query ,Grade.class);

    }

    @Override
    public void updateGrade(Grade grade) {
        Query query  = new Query(Criteria.where("_id").is(grade.getId()));
        Update update =new Update();
        update.set("name",grade.getGradeName());
        update.set("gradeName",grade.getGradeName());
        mongoTemplate.updateFirst(query,update,Grade.class);
    }

    // todo 根据编号查询
    @Override
    public Grade getById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Grade grade = mongoTemplate.findOne(query,Grade.class);
        return grade;
    }

    //todo 查询所有
    @Override
    public List<Grade> listGrades() {
        return mongoTemplate.findAll(Grade.class);
    }
}
