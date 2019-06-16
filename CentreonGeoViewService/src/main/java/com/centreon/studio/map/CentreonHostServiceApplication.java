package com.centreon.studio.map;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.centreon.studio.map.rest.geoview.dao.GeoViewRepository;
import com.centreon.studio.map.rest.geoview.entity.GeoCoordinateEntity;
import com.centreon.studio.map.rest.geoview.entity.GeoViewEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CentreonHostServiceApplication implements CommandLineRunner {

	@Autowired
	private GeoViewRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CentreonHostServiceApplication.class, args);
	}

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.centreon.studio.map.rest.studio.dao"))
				.paths(PathSelectors.any()).build().pathMapping("/centreon-studio/rest");
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		GeoCoordinateEntity coord = new GeoCoordinateEntity(10f, 33f);

		GeoViewEntity geoView = new GeoViewEntity();
		geoView.setId(UUID.randomUUID());
		geoView.setName("TestGeoView");
		geoView.setZoom(50f);
		geoView.setPosition(coord);

		repository.save(geoView);

	}

}
