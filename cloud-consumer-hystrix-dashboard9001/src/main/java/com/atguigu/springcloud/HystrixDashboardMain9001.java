package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 类名称: HystrixDashboardMain9001
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/11/1 0001 9:47
 *
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard  //配置hystrix仪表盘监控
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
