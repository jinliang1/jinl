package ddbes.exam.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ddbes.exam.demo.entity.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.mapper
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/14 13:27
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    //todo 插入
    @Insert("insert into record(u_id,pa_id,start_time,status) values (#{uId},#{paId},#{startTime},#{status}")
    int saveRecord(@Param("uId") String uId, @Param("paId") String paId,
                   @Param("startTime") Long startTime, @Param("status") String status);
    //todo 更新
    @Update("update record score=#{score},completionTime=#{completionTime},status =#{status} where rId=#{rId} ")
    int updateRecord(@Param("score") String score, @Param("completionTime") Long completionTime,
                     @Param("status") String status, @Param("rId") String rId);

}
