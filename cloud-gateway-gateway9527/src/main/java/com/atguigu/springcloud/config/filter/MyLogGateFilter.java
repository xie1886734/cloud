package com.atguigu.springcloud.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 类名称: MyLogGateFilter
 * 类描述: TODO
 * 创建人: 谢洪喜
 * 创建时间 2020/11/1 0001 16:05
 *
 * @Version 1.0
 */
@Component
@Slf4j
public class MyLogGateFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("************* 日期："+new Date());
      String  uname=exchange.getRequest().getQueryParams().getFirst("uname");
      if(uname ==null){
          log.info("***********用户名为null，非法用户");
          exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
          return exchange.getResponse().setComplete();
      }
        return chain.filter(exchange);
    }
//
    @Override
    public int getOrder() {
        return 0;
    }
}
