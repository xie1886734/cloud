package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 类名称: OrderController
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/26 0026 14:36
 *
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer/")
public class OrderController {

    private static  final String PAYMENT_URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("zk")
    public String   create() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }

}
