package com.centreon.studio.map.rest.centreon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centreon.studio.map.rest.centreon.entity.Service;

//@RepositoryRestResource(collectionResourceRel = "services", path = "services")
public interface CentreonServiceDao extends JpaRepository<Service, Integer> {

}
