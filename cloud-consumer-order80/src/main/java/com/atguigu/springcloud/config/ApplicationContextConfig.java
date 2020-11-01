package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 类名称: ApplicationContextConfig
 * 类描述: 分布式微服务配置类  服务调用  作用是一个springboot端口调用另外一个springboot端口
 * 创建人: 谢洪喜
 * 创建时间 2020/10/20 0020 11:45
 *
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * 服务调用
     * @return
     */
    @Bean
  @LoadBalanced  //开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
