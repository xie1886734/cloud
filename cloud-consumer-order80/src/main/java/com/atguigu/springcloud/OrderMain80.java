package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 类名称: OrderMain80
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/20 0020 11:39
 *
 * @Version 1.0
 */
@SpringBootApplication
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)//服务调用，自定义服务器选择规则
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
