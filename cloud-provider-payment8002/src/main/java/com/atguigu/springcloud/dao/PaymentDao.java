package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 类名称: PaymentDao
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/20 0020 10:36
 *
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    /**
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
