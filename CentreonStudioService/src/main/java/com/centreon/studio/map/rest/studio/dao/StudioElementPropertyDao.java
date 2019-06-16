package com.centreon.studio.map.rest.studio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.centreon.studio.map.rest.studio.entity.ElementProperty;
import com.centreon.studio.map.rest.studio.entity.ElementPropertyId;

@RepositoryRestResource(collectionResourceRel = "elementproperties", path = "elementproperties")
public interface StudioElementPropertyDao extends JpaRepository<ElementProperty, ElementPropertyId> {

}
