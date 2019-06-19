package com.centreon.studio.map.rest.studio.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centreon.studio.map.rest.studio.dao.StudioElementDao;
import com.centreon.studio.map.rest.studio.entity.Element;

@Service
public class StudioElementService {

	@Autowired
	private StudioElementDao studioElementDao;

	@Autowired
	private CentreonHostServiceClient centreonHostService;

	/**
	 * Mon business logic
	 * 
	 * @return
	 */
	public String updateElementsWithHosts() {
		String elements = studioElementDao.findAll().stream().limit(5).map(Element::toString)
				.collect(Collectors.joining());

		return elements + "-------------------------------------------------------------" + centreonHostService.getAllCentreonHosts();
	}

}
