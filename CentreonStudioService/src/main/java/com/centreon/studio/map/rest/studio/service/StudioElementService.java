package com.centreon.studio.map.rest.studio.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.centreon.studio.map.rest.studio.dao.StudioElementDao;
import com.centreon.studio.map.rest.studio.entity.Element;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudioElementService {

	private final String hostServiceUrl = "http://centreon-host-service";
	private final String HOSTS_PATH = "/hosts";
	
	@Autowired
	private StudioElementDao studioElementDao;
	
	@Autowired 
	protected RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getAllCentreonHostsFallBack")
	public String getAllCentreonHosts() {
	    log.info("Calling  all host for centreon-host-service");
	    ResponseEntity<String> response = restTemplate.getForEntity(hostServiceUrl + HOSTS_PATH, String.class);
	    return response.getBody();
	}

	public String getAllCentreonHostsFallBack() {
	    log.info("Calling fall get all centreon hots");
	    String response = "Fall back response get all hosts";
	    return response;
	}
	
	/**
	 * Mon business logic
	 * 
	 * @return
	 */
	public String updateElementsWithHosts() {
		String elements = studioElementDao.findAll().stream().map(Element::toString).collect(Collectors.joining());
		
		return elements + "/n" + getAllCentreonHosts();
	}
	
}
