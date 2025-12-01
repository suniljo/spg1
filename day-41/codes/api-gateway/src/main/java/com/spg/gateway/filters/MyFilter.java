package com.spg.gateway.filters;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println(" filter() - executed..... ");
		
		//validate request
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders requestHeaders = request.getHeaders();
		
		Set<String> headerKeys =requestHeaders.keySet();
		
		if(!headerKeys.contains("Secret")) {
			throw new RuntimeException("Invalid Request");
		}
		
		List<String> list = requestHeaders.get("Secret");
		if(!list.get(0).equals("sunil@123")) {
			throw new RuntimeException("Invalid Request.. provided header is not Valid");
		}
		
		return chain.filter(exchange);
	}

}
