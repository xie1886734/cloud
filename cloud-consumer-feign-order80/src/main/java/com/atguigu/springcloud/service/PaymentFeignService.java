package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 接口名称: PaymentFeignService
 * 接口描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/28 0028 12:04
 *
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//具体访问哪一个服务
public interface PaymentFeignService {

    @GetMapping("payment/getPaymentById/{id}")
     CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("payment/create")
    public CommonResult<Payment> create(Payment payment);
    @GetMapping("payment/fegin/timeout")
    public  String  feginTimeOut();
}
