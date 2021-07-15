package ddbes.exam.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ddbes.exam.demo.entity.UserFlag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.mapper
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 8:32
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Mapper
public interface UserFlagMapper extends BaseMapper<UserFlag> {
    @Insert("insert into user_flag (u_id,course,flag) values (#{uId},#{course},#{flag})")
    int save(@Param("uId") String uId, @Param("course") String course, @Param("flag") int flag);

}
