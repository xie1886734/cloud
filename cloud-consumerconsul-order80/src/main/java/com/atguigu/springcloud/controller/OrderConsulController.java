package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 类名称: OrderController
 * 类描述: 订单模块
 * 创建人: 谢洪喜
 * 创建时间 2020/10/20 0020 11:42
 *
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer/")
public class OrderConsulController {
    private static  final String PAYMENT_URL="http://consul-provider-payment-";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("consul")
    public String   create() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
