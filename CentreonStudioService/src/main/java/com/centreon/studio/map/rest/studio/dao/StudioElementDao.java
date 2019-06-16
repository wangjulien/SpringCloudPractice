package com.centreon.studio.map.rest.studio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.centreon.studio.map.rest.studio.entity.Element;

@RepositoryRestResource(collectionResourceRel = "elements", path = "elements")
public interface StudioElementDao extends JpaRepository<Element, Long> {

}
