package com.centreon.studio.map.rest.studio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.ToString;

/**
 * @author jwang
 *
 */
@ToString(onlyExplicitlyIncluded = true)
@Embeddable
public class ElementPropertyId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2670875704268027314L;

	@Column(name = "element_id", nullable = false)
	private Long elementId;

	@ToString.Include
	@Column(name = "name", nullable = false)
	private String name;

}
