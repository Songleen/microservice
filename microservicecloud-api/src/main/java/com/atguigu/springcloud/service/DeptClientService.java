package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/09/19:08
 */
@FeignClient("MICROSERVICECLOUD-DEPT")
// @FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/add")
    boolean add(Dept dept);

    @RequestMapping(value = "/dept/get/{id}")
    Dept get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list")
    List<Dept> list();

}
