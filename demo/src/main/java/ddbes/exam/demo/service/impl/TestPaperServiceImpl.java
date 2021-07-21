package ddbes.exam.demo.service.impl;

import com.sun.org.glassfish.gmbal.AMXMetadata;
import ddbes.exam.demo.entity.TestPaper;
import ddbes.exam.demo.service.TestPaperService;
import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 15:47
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Component
public class TestPaperServiceImpl implements TestPaperService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void saveTestPaper(TestPaper testPaper) {
        mongoTemplate.save(testPaper);
    }

    @Override
    public void removeTestPaper(String id) {

    }

    @Override
    public void updateTestPaper(TestPaper testPaper) {

    }

    @Override
    public TestPaper getById(String id) {
        return null;
    }

    @Override
    public TestPaper getTestPaper(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,TestPaper.class);
    }
}
