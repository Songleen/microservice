package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import com.atguigu.springcloud.service.DeptTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/08/16:16
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @Autowired
    private DeptTestService testService;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        System.out.println("请求过来了");
        List<Dept> list = service.list();
        System.out.println(list);
        return list;
    }

    @RequestMapping(value="/consumer/dept/list/test")
    public List<Dept> getList(){
        System.out.println("test的请求过来了");
        List<Dept> depts = testService.list();
        return depts;
    }

}
