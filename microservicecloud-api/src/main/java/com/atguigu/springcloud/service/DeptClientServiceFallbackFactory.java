package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/10/9:46
 */
// @Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    //通过这个接口将DeptClientService接口中的每一个方法的熔断机制统一放在此处处理，实现与Controller类的解耦
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("这是测试服务降级的信息；===== 该ID：\"+id+\"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
