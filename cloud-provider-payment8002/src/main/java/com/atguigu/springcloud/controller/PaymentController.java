package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * 类名称: PaymentController
 * 类描述: 支付模块
 * 创建人: 谢洪喜
 * 创建时间 2020/10/20 0020 11:01
 *
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment/")
public class PaymentController {
    @Autowired
    @Qualifier("IPaymentService")
    private IPaymentService paymentService;
    @Value("${server.port}")
    private  String  serverPort;
    @PostMapping("create")
    public CommonResult<?> create( @RequestBody Payment payment){

        CommonResult commonResult= new CommonResult();
        int result=paymentService.create(payment);
        log.info("***插入结果"+result);
        if(result>0){
       commonResult.setCode(200);
       commonResult.setData(result);
            commonResult.setMessage("插入成功!"+serverPort);
        }else{
            commonResult.setCode(444);
            commonResult.setMessage("插入失败!");
        }
        return  commonResult;
    }
@GetMapping("getPaymentById/{id}")
    public CommonResult<?> getPaymentById(@PathVariable("id") Long id){
    CommonResult<Payment> commonResult= new CommonResult<>();

    Payment payment = paymentService.getPaymentById(id);
    log.info("**查询结果"+payment);
    if(payment!=null){
        commonResult.setCode(200);
commonResult.setData(payment);
        commonResult.setMessage("查询成功!"+serverPort);
    }else{
        commonResult.setCode(444);
        commonResult.setMessage("查询失败!，查询id"+id);
    }
return  commonResult;
}
    @GetMapping("lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/fegin/timeout")
    public  String  feginTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  serverPort;
    }
}
