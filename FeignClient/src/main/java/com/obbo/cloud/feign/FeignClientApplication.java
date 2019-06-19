package com.obbo.cloud.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obbo.cloud.feign.clients.DocumentClient;

/**
 * 
 * Light Feign client without Hystrix stream and Hystrix Dashboard 
 * 
 * @author jwang
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Controller
public class FeignClientApplication {
	
	@Autowired
	private DocumentClient greetingClient;

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
	
	@RequestMapping("/get-documents")
	public String greeting(Model model) {
		model.addAttribute("documents", greetingClient.getDocuments());
		return "greeting-view";
	}
}
