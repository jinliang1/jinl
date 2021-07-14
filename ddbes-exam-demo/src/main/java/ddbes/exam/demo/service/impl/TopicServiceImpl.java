package ddbes.exam.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ddbes.exam.demo.entity.Topic;
import ddbes.exam.demo.mapper.TopicMapper;
import ddbes.exam.demo.service.TopicService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.service.impl
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/9 10:54
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {
}
