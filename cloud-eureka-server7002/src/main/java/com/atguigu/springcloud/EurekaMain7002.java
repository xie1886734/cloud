package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 类名称: EurekaMain7001
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/21 0021 9:23
 *
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer   //注册服务
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);
    }
}
