package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/07/17:10
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.atguigu.springcloud"})
//@MapperScan(basePackages = {"com.atguigu.springcloud.dao"})
@EnableEurekaClient
@EnableDiscoveryClient //启用eureka的服务发现
@EnableCircuitBreaker  //启动服务熔断
public class DeptProvider8801_Hystrix_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8801_Hystrix_App.class, args);
    }
}