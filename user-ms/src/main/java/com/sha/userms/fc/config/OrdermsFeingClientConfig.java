package com.sha.userms.fc.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "orderms")
public interface OrdermsFeingClientConfig {
	
	@RequestMapping(method = RequestMethod.GET,
			value = "/orders",
			consumes = "Application/Json")
	public Object getAllOrders();

}
