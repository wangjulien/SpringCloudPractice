package com.centreon.studio.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@Import(SpringDataRestConfiguration.class)
public class CentreonHostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentreonHostServiceApplication.class, args);
	}

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.centreon.studio.map.rest.centreon.dao"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/centreon-studio/rest");
	}

}
