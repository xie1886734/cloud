package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类名称: OrderHystrixController
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/29 0029 10:26
 *
 * @Version 1.0
 */
@RestController
@Slf4j
//全局服务降级方法，该注解使用的是就近原则如果没有配置@HystrixCommand注解出现异常或超时还是会抛出，如果使用了@HystrixCommand就会调用全局的降级方法，就近原则
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
  public    String paymentInfo_Ok(@PathVariable("id") Integer id){
        return  paymentHystrixService.paymentInfo_Ok(id);
    }
//@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
     //   @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//})
   @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
    //    int i=10/0;
        return  paymentHystrixService.paymentInfo_TimeOut(id);
    }

public  String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
    return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
}

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
