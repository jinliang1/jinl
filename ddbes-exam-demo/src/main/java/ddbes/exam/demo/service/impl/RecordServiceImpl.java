package ddbes.exam.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.Record;
import ddbes.exam.demo.mapper.RecordMapper;
import ddbes.exam.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/14 13:31
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Autowired
    private  RecordMapper recordMapper;


    @Override
    public int saveRecord(String uId, String paId, Long startTime,String status) {
        return recordMapper.saveRecord(uId,paId,startTime,status);
    }

    @Override
    public int updateRecord(String score, Long completionTime, String status, String rId) {
        return recordMapper.updateRecord(score,completionTime,status,rId);
    }

    @Override
    public Record getRecord(String paId) {
        return getOne(new QueryWrapper<Record>().lambda()
        .eq(Record::getPaId,paId));
    }
}
