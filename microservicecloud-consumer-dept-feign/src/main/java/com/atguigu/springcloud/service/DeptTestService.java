package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/12/19/22:23
 */

// 如果这里通过名字指定微服务，它会结合Ribbon调用，并做负载均衡
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
// 如果通过url指定微服务，它不会结合Ribbon，直接构建请求发送
// @FeignClient(url = "www")
public interface DeptTestService{

     @RequestMapping(value="/dept/list")
     List<Dept> list();
}
