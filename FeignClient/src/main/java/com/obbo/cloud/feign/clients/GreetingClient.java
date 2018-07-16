package com.obbo.cloud.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("config-client")
public interface GreetingClient {
	
	@RequestMapping("/greeting")
	public String greeting();
}
