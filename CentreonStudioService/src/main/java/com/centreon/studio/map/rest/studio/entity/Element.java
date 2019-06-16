package com.centreon.studio.map.rest.studio.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.Data;

/**
 * @author jwang
 *
 */
@Data
@Entity
@Table(name = "element")
public class Element {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type")
	private int type;

	@Column(name = "resource_type")
	private Integer resourceType;

	@Column(name = "resource_id")
	private Long resourceId;

	@Column(name = "element_template_id")
	private Long elementTemplateId;

	@Column(name = "desynchroDate", columnDefinition = "DATETIME")
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private LocalDateTime desynchroDate;

	@Column(name = "is_template")
	private boolean isTemplate;

	@OneToMany(mappedBy = "element", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private Set<ElementProperty> elementProperties = new HashSet<ElementProperty>(0);

}
