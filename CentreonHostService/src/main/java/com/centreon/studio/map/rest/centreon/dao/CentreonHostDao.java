package com.centreon.studio.map.rest.centreon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centreon.studio.map.rest.centreon.entity.Host;

//@RepositoryRestResource(collectionResourceRel = "hosts", path = "hosts")
public interface CentreonHostDao extends JpaRepository<Host, Integer> {

	// List<Host> getAllByHostActivate(String activateState);

	/**
	 * Find all hosts or templates regardless their activate state
	 * 
	 * @param value
	 * @return
	 */
	List<Host> getAllByHostRegister(String value);

	/**
	 * Find all hosts / templates according to their activate state and register
	 * type
	 * 
	 * @param activeState  : active or not
	 * @param registerType : host, template or meta host type
	 * @return
	 */
	List<Host> getAllByHostActivateAndHostRegister(String activeState, String registerType);

}
