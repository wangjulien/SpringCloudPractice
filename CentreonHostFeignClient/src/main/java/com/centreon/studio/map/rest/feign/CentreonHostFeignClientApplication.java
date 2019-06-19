package com.centreon.studio.map.rest.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centreon.studio.map.rest.feign.clients.HostServiceClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@RestController
public class CentreonHostFeignClientApplication {

	@Autowired
	private HostServiceClient hostServiceClient;

	public static void main(String[] args) {
		SpringApplication.run(CentreonHostFeignClientApplication.class, args);
	}

	@GetMapping("/get-hosts")
	public String getHosts() {
		return hostServiceClient.getHosts();
	}
}
