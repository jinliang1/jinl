package ddbes.exam.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ddbes.exam.demo.entity.Record;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/14 13:28
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
public interface RecordService extends IService<Record> {
    int saveRecord(String rId,String uId,String paId, Long startTime,String status);
    int updateRecord(String score,  Long completionTime,String status,String rId);
    Record getRecord(String paId);
}
