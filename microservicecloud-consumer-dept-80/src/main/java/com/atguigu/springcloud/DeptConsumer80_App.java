package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/08/16:32
 */
@SpringBootApplication
@EnableEurekaClient     //开启负载均衡也需要开启这个注解
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
