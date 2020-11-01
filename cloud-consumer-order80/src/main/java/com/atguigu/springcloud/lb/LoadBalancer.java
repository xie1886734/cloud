package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 接口名称: LoadBalancer
 * 接口描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/28 0028 10:28
 *
 * @Version 1.0
 */
public interface LoadBalancer {

    /**
     * 收集服务上有多少台服务器，放入list集合中
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
