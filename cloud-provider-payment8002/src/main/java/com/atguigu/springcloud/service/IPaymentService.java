package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * 接口名称: IPaymentService
 * 接口描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/20 0020 10:58
 *
 * @Version 1.0
 */
public interface IPaymentService {
    /**
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
