package ddbes.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 10:05
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@SpringBootApplication
//todo SpringCloudApplication 中有 hystrix熔断 ，启动不成功
@EnableSwagger2
//todo 注册到服务中心
@EnableDiscoveryClient
public class ExamDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(ExamDemoApp.class,args);
    }
}
