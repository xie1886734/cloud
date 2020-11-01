package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * 类名称: PaymentHystrixServiceImpl
 * 类描述: 出现错误调用的类,服务降级
 * 创建人: 谢洪喜
 * 创建时间 2020/10/29 0029 14:27
 *
 * @Version 1.0
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "PaymentHystrixServiceImpl fall paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return  "PaymentHystrixServiceImpl fall paymentInfo_TimeOut";
    }
}
