package com.bo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 注册服务到Eureka-server
@EnableHystrix // 开启断路器Hystrix
@EnableHystrixDashboard // 开启断路器仪表盘HystrixDashboard
public class EurekaClientRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientRibbonApplication.class, args);
	}
	
	@Bean // 向spring容器注入RestTemplate实例
	@LoadBalanced // 开启负载均衡的功能
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
