package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类名称: MySelfRule
 * 类描述: 自定义服务调用规则，Ribbon
 * 创建人: 谢洪喜
 * 创建时间 2020/10/27 0027 15:40
 *
 * @Version 1.0
 */
@Configuration
public class MySelfRule {
@Bean
    public IRule myRule(){
        return  new RandomRule();
    }
}
