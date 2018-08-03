package com.obbo.cloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class ConfigClientApplication {
	
	@Value("${user.role}")
	private String role;
	
	@Value("${user.password}")
	private String password;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@RequestMapping(value = "/whoami/{username}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String whoami(@PathVariable("username") String username) {
		return String.format("Hello ! You're %s and you'll become a %s, but only if your password is '%s' ...\n", username, role, password);
	}
	
	@RequestMapping("/greeting")
    public String greeting() {
        return "Hello from EurekaClient!";
    }
}
