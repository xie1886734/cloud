package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * 类名称: FeignConfig
 * 类描述: TFeign日志加强配置类
 * 创建人: 谢洪喜
 * 创建时间 2020/10/28 0028 19:40
 *
 * @Version 1.0
 */
@Configuration
public class FeignConfig {
@Bean
    Logger.Level feignLoggerConfig(){
        return  Logger.Level.FULL;//打印所有详细信息
    }
}
