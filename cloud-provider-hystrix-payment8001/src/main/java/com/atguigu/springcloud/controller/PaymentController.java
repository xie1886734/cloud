package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称: PaymentController
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/28 0028 21:57
 *
 * @Version 1.0
 */
@RestController
@Slf4j

public class PaymentController {
    @Autowired
    @Qualifier("IPaymentService")
    private IPaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    /**
     * 正常的方法
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
  public   String  paymentInfo_Ok(@PathVariable("id") Integer id){
        String  result=paymentService.paymentInfo_Ok(id);
        log.info("***********result"+result);
      return   result;
    }

    /**
     * 异常的方法
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public  String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String  result=paymentService.paymentInfo_TimeOut(id);
        log.info("***********result"+result);
        return   result;
    }
    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String  result=paymentService.paymentCircuitBreaker(id);
        log.info("***********result"+result);
        return   result;
    }
}
