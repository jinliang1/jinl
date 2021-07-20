package ddbes.exam.demo.service.impl;

import com.alibaba.fastjson.JSON;
import ddbes.exam.demo.entity.Student;
import ddbes.exam.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/19 16:35
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private MongoTemplate mongoTemplate;

    //todo 新增
    @Override
    public void saveStudent(Student student) {
        mongoTemplate.save(student);
    }

    // todo 删除
    @Override
    public void removeStudent(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Student.class);
    }

    // todo 修改
    @Override
    public void updateStudent(Student student) {
        Query query = new Query(Criteria.where("_id").is(student.getId()));
        Update update = new Update();
        update.set("name", student.getName());
        update.set("sex", student.getSex());
        update.set("gradeId", student.getGradeId());
        mongoTemplate.updateFirst(query, update, Student.class);
    }

    // todo 根据编号查询
    @Override
    public Student getById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Student student = mongoTemplate.findOne(query, Student.class);
        return student;
    }

    // todo 查询所有
    @Override
    public List<Student> listStudent() {
        return mongoTemplate.findAll(Student.class);
    }

    // todo 两表查询
    @Override
    public Object getStudentAndGrade() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("student") //关联从表名
                .localField("_id") //主表关联字段
                .foreignField("gradeId") //从表关联字段
                .as("GradeAndStu");   //查询结构  查询结果名
        //带条件查询可以选择添加下面的条件
   /*    Criteria criteria=Criteria.where("studenAndgrade").not().size(0);//只查询有结果的学生
        Criteria qqq=Criteria.where("name").regex("文");//只查询名字中带有文
       AggregationOperation match1= Aggregation.match(qqq);
        AggregationOperation match = Aggregation.match(criteria);
        Aggregation counts = Aggregation.newAggregation(match1,lookupOperation,match);*/
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
        List<Map> results = mongoTemplate
                .aggregate(aggregation, "grade", Map.class).getMappedResults();
        //上面的student必须是查询主表名
        //System.out.println(JSON.toJSONString(results));
        return results;
    }
}
