package com.bo.cloud.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


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
	private String serviceUrl = "http://EUREKA-CLIENT-PROVIDER";
	
	public String invokeSay(String content) {
		Map<String, Object> reqMap = new HashMap<>();
		reqMap.put("str", content);
		return restTemplate.getForObject(serviceUrl + "/test/say?str={str}", String.class, reqMap);
	}
}
