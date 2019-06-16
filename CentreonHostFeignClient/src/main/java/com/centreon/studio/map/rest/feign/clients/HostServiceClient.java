package com.centreon.studio.map.rest.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "centreon-host-service", fallback = HostServiceClientFailure.class)
public interface HostServiceClient {
	
	@GetMapping("/hosts")
	public String getHosts();
}
