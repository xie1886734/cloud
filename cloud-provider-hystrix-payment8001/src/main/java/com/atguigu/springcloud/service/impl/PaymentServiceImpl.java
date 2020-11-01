package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * 类名称: PaymentServiceImpl
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/28 0028 21:51
 *
 * @Version 1.0
 */
@Service("IPaymentService")
public class PaymentServiceImpl implements IPaymentService {
    //服务降级
    @Override
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_Ok, id:" + id + "正常";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            //  @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000"), // 限制请求时间3
            // 秒钟以内为正常，超时抛出异常，调用指定的方法
    })  //服务降级 ，响应超时或异常掉用指定方法
    @Override
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int timeNumber = 5;
        //  int a=10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOut, 耗时(秒):";
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "8001系统繁忙,出错兜底 ";
    }


    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("***** id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {

        return "id 不能负数，请稍后再试 id：" + id;
    }
}
