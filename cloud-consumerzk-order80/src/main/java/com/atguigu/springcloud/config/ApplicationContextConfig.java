package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 类名称: ApplicationContextConfig
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/10/26 0026 14:10
 *
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced   //负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
