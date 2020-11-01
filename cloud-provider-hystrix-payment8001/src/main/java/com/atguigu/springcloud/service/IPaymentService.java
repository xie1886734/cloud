package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * 接口名称: IPaymentService
 * 接口描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/28 0028 21:49
 *
 * @Version 1.0
 */
public interface IPaymentService {
    /**
     * 正常的方法
     * @param id
     * @return
     */
    String  paymentInfo_Ok(@PathVariable("id")  Integer id);

    /**
     * 异常的方法
     * @param id
     * @return
     */
    String paymentInfo_TimeOut(@PathVariable("id")  Integer id);

    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
