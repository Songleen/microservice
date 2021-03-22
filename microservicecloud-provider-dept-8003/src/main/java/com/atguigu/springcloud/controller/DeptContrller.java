package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/07/17:05
 */

@RestController
public class DeptContrller {

    @Autowired
    private DeptService service;

    @RequestMapping(value="/dept/add",method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable("id")Long id){
        return service.getById(id);
    }

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list() {
        List<Dept> list = service.list();
        return list;
    }

    //服务发现
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){

        //获取注册到eureka中的所有服务
        List<String> services = discoveryClient.getServices();
        System.out.println("eureka中现在注册的服务有："+services);

        //获取某个服务的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+"\t"+instance.getServiceId()+"\t"+instance.getPort()+"\t"+instance.getUri()+"\t"+instance.getMetadata());
        }
        return this.discoveryClient;
    }
}
