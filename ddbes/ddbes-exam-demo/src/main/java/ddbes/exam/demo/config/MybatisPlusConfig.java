package ddbes.exam.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.config
 * @Description: java类作用描述:配置mybatis的分页
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/19 13:44
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Configuration
@ConditionalOnClass(value = {PaginationInterceptor.class})
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        return  paginationInterceptor;
    }
}
