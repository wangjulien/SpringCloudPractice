package com.centreon.studio.map.rest.studio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centreon.studio.map.rest.studio.service.StudioElementService;

@RestController
@RequestMapping("/elements")
public class StudioElementController {

	@Autowired
	private StudioElementService studioElementService;

	@GetMapping
	public ResponseEntity<String> getElementsWithHosts() {
		String result = studioElementService.updateElementsWithHosts();

		return ResponseEntity.ok(result);
	}

}
