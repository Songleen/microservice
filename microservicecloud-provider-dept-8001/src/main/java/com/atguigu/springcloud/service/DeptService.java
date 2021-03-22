package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;

import java.util.List;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/07/17:00
 */
public interface DeptService {
    boolean add(Dept dept);
    Dept getById(Long id);
    List<Dept> list();
}
