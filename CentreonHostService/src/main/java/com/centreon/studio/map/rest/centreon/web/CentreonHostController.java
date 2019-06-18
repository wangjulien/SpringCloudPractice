package com.centreon.studio.map.rest.centreon.web;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centreon.studio.map.rest.centreon.dao.CentreonHostDao;
import com.centreon.studio.map.rest.centreon.entity.Host;

@RestController("/hosts")
public class CentreonHostController {
	
	@Autowired
	private CentreonHostDao centreonHostDao;
	
	@GetMapping
	public ResponseEntity<String> getAllHostAsString() {
		String result = centreonHostDao.findAll().stream().map(Host::toString).collect(Collectors.joining());

		return ResponseEntity.ok(result);
	}

}
