package ddbes.exam.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ddbes.exam.demo.entity.Question;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.mapper
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/8 9:42
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}
