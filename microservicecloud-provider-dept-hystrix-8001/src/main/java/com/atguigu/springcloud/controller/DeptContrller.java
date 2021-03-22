package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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



    /**
     * 一旦调用服务方法失败并抛出了错误信息后，
     * 会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
     */
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable("id")Long id){
        Dept dept = service.getById(id);
        if (dept == null){
            throw new RuntimeException("该ID："+id+"没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id")Long id ){
        return new Dept().setDeptno(id)
                .setDname("该ID："+id+"没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
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
