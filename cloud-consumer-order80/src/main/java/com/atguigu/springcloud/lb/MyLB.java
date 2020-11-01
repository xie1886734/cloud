package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类名称: Mylb
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/28 0028 10:59
 *
 * @Version 1.0
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

public  final  int getAndIncrement(){
    //当前服务器访问下表
    int current;
    //下一次的小标
    int next;
    do {
        //获取当前的访问的下表
current=this.atomicInteger.get();
//下一次的下标  ，如果服务器数量小于Integer的最大值，则当前服务器加一
next=current>=Integer.MAX_VALUE ? 0:current+1;
    }while (!this.atomicInteger.compareAndSet(current, next));//CAS比较并替换
    System.out.println("******第几次访问，次数："+next);
    return  next;
}
    //负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
    int index=getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }

}
