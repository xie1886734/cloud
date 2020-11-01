package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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
public class OrderController {
    //调用服务着支付   eureka中对外暴露的服务名称 服务名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("payment/create")
    public CommonResult<Payment> create(Payment payment) {
        //返回对象为响应体中数据转化成的对象，基本上可以理解为Json
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
    }

    @GetMapping("payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById1(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
        //返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
        //请求成功
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info(entity.getStatusCode().toString());
            return entity.getBody();
        } else {
            return new CommonResult<Payment>(444, "异常");
        }
    }

    @GetMapping("payment/create1")
    public CommonResult<Payment> create1(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment
                , CommonResult.class);
        //返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
        //请求成功
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<Payment>(444, "异常");
        }
    }
//自定义ribbon负载均衡，原来的负载均衡不在起作用
    @GetMapping("payment/lb")
    public  String  paymentLB(){
        List<ServiceInstance> instanceList=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
   if(instanceList==null||instanceList.size()<=0){
       return  null;
   }else{
       ServiceInstance serviceInstance=loadBalancer.instances(instanceList);
       URI uri = serviceInstance.getUri();
       return restTemplate.getForObject(uri + "/payment/lb", String.class);
   }

    }
}
