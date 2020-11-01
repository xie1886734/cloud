package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 类名称: OrderzkMain80
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/26 0026 14:45
 *
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderzkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderzkMain80.class,args);
    }
}
