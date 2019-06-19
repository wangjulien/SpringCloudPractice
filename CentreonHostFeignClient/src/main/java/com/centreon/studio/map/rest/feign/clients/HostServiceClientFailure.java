package com.centreon.studio.map.rest.feign.clients;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HostServiceClientFailure implements HostServiceClient {

	@Override
	public String getHosts() {
		log.info("Calling fall get all centreon hots");
		String response = "Fall back response get all hosts";
		return response;
	}

}
