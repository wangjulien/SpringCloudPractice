package com.centreon.studio.map.rest.geoview.dao;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.centreon.studio.map.rest.geoview.entity.GeoViewEntity;

@RepositoryRestResource(collectionResourceRel = "geoviews", path = "geoviews")
public interface GeoViewRepository extends MongoRepository<GeoViewEntity, UUID> {

}
