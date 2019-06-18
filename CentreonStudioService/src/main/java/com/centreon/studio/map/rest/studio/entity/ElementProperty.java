package com.centreon.studio.map.rest.studio.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.ToString;

@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "element_property")
public class ElementProperty {
	
	@ToString.Include
	@EmbeddedId
	private ElementPropertyId id;

	@MapsId("elementId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "element_id")
	private Element element;
	
	@ToString.Include
	@NonNull
	@Column(name = "value", nullable = false, columnDefinition = "TEXT")
	private String value;

}
