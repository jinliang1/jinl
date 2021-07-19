package com.ddbes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ProjectName: ddbes-template
 * @Package: com.ddbes
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/6 14:43
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class TemplateApp {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApp.class,args);
    }
}
