package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类名称: OrderController
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/28 0028 12:03
 *
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer/")
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("payment/create")
    public CommonResult<Payment> create(Payment payment) {
        //返回对象为响应体中数据转化成的对象，基本上可以理解为Json
        return paymentFeignService.create(payment);
    }

    @GetMapping("payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * 测试超时时间
     * @return
     */
    @GetMapping("payment/fegin/timeout")
    public  String  feginTimeOut(){
        return  paymentFeignService.feginTimeOut();
    }
}
