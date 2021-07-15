package ddbes.exam.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ddbes.exam.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.mapper
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 10:24
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
