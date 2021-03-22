package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/07/16:20
 */
//springboot与mybatis整合，接口上面一定要加这个注解，否则springboot不能识别；如果不写，则可以在主程序那里写上@mapperscan
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);
    Dept findById(@Param(value = "deptno") Long id);
    List<Dept> findAll();

}
