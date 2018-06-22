package com.bo.cloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.cloud.service.EurekaRibbonService;

/**
 * @Description 
 * @Author 王博
 * @Version 2018年6月22日　下午3:52:58
 * @码云 https://gitee.com/LeisureBo
 */
@RestController
public class EurekaRibbonController {
	
	@Resource
	private EurekaRibbonService ribbonService;
	
	@RequestMapping("/say/{content}")
	public String trySay(@PathVariable("content") String content) {
		return ribbonService.invokeSay(content);
	}
}
