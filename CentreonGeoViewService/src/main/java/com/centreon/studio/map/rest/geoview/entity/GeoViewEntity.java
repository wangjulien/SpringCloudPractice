package com.centreon.studio.map.rest.geoview.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "GeoView")
public class GeoViewEntity {

	@Id
	private UUID id;

	private String name;

	private GeoCoordinateEntity position;

	private float zoom;

	private boolean markerClustering;

	private List<Long> hostGroupIds = new ArrayList<>();

}
