package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/06/17:58
 */
@SuppressWarnings("serial")
@AllArgsConstructor //生成全参构造
@NoArgsConstructor  //生成空参构造
@Data   //生成setter getter
@Accessors(chain = true) //链式访问
public class Dept implements Serializable{

    private Long deptno;
    private String dname;
    private String db_source; //来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库；
}
