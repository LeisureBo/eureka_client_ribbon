package com.bo.cloud.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/**
 * @Description 
 * @Author 王博
 * @Version 2018年6月22日　下午3:30:19
 * @码云 https://gitee.com/LeisureBo
 */
@Service
public class EurekaRibbonService {
	
	@Resource
	private RestTemplate restTemplate;
	
	// 这里调用的服务地址直接使用服务提供者在注册中心注册的应用名即可
	@Value("${ribbon.invoke.service-url}")
	private String serviceUrl;
	
	// @HystrixCommand注解对该方法创建了熔断器功能并指定了fallbackMethod熔断方法
	@HystrixCommand(fallbackMethod = "sayError")
	public String invokeSay(String content) {
		Map<String, Object> reqMap = new HashMap<>();
		reqMap.put("str", content);
		return restTemplate.getForObject(serviceUrl + "/test/say?str={str}", String.class, reqMap);
	}
	
	// fallbackMethod熔断方法:当开启熔断器的服务不可用时直接返回该方法设置的默认值而不是等待响应超时
	public String sayError(String content) {
		return "sorry, service error! [from Ribbon Hystrix]";
	}
	
}
