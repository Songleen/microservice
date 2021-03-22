package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName microservicecloud
 * @Author Songleen
 * @Date 2019/07/08/16:13
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced  //SpringCloud Ribbion是基于Netflix Ribbon实现的一套客户端负载均衡工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //在此处，如果没有显示的声明用哪种算法，则默认用轮询算法，比如这里申明了随机算法，则采取随机算法；
//    @Bean
//    public IRule getRule(){
//        return new RandomRule();
//    }
}
