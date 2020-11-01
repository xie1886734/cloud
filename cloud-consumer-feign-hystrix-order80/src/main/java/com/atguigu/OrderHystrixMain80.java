package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 类名称: springcloud
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/29 0029 10:23
 *
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix   //激活容错降级
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
