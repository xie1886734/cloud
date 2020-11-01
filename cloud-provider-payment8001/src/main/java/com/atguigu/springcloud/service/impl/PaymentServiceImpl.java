package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类名称: PaymentServiceImpl
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/20 0020 10:59
 *
 * @Version 1.0
 */
@Service("IPaymentService")
public class PaymentServiceImpl implements IPaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
