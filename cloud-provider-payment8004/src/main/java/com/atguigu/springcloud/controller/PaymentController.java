package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 类名称: PaymentController
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/26 0026 12:12
 *
 * @Version 1.0
 */
@RestController
@RequestMapping("/payment/")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private  String  serverPort;
    @GetMapping("zk")
public  String  paymentzk(){
     return  "springcloud with zookeeper"+serverPort+ UUID.randomUUID().toString();
}

}
