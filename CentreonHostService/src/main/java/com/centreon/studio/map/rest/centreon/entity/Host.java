package com.centreon.studio.map.rest.centreon.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author jwang
 *
 */
@Data
@Entity
@Table(name = "host")
public class Host {

	@Id
	@Column(name = "host_id")
	private Integer hostId;

	@Column(name = "host_template_model_htm_id")
	private Integer hostTemplateModelHtmId;

	@Column(name = "command_command_id_arg1", columnDefinition = "TEXT")
	private String commandCommandIdArg1;

	@Column(name = "command_command_id_arg2", columnDefinition = "TEXT")
	private String commandCommandIdArg2;

	@Column(name = "host_name")
	private String hostName;

	@Column(name = "host_alias")
	private String hostAlias;

	@Column(name = "host_address")
	private String hostAddress;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "host_max_check_attempts")
	private Integer hostMaxCheckAttempts;

	@Column(name = "host_check_interval")
	private Integer hostCheckInterval;

	@Column(name = "host_retry_check_interval")
	private Integer hostRetryCheckInterval;

	@Column(name = "host_active_checks_enabled")
	private String hostActiveChecksEnabled;

	@Column(name = "host_passive_checks_enabled")
	private String hostPassiveChecksEnabled;

	@Column(name = "host_checks_enabled")
	private String hostChecksEnabled;

	@Column(name = "initial_state")
	private String initialState;

	@Column(name = "host_obsess_over_host")
	private String hostObsessOverHost;

	@Column(name = "host_check_freshness")
	private String hostCheckFreshness;

	@Column(name = "host_freshness_threshold")
	private Integer hostFreshnessThreshold;

	@Column(name = "host_event_handler_enabled")
	private String hostEventHandlerEnabled;

	@Column(name = "host_low_flap_threshold")
	private Integer hostLowFlapThreshold;

	@Column(name = "host_high_flap_threshold")
	private Integer hostHighFlapThreshold;

	@Column(name = "host_flap_detection_enabled")
	private String hostFlapDetectionEnabled;

	@Column(name = "flap_detection_options")
	private String flapDetectionOptions;

	@Column(name = "host_process_perf_data")
	private String hostProcessPerfData;

	@Column(name = "host_retain_status_information")
	private String hostRetainStatusInformation;

	@Column(name = "host_retain_nonstatus_information")
	private String hostRetainNonstatusInformation;

	@Column(name = "host_notification_interval")
	private Integer hostNotificationInterval;

	@Column(name = "host_notification_options")
	private String hostNotificationOptions;

	@Column(name = "host_notifications_enabled")
	private String hostNotificationsEnabled;

	@Column(name = "contact_additive_inheritance")
	private Boolean contactAdditiveInheritance;

	@Column(name = "cg_additive_inheritance")
	private Boolean cgAdditiveInheritance;

	@Column(name = "host_first_notification_delay")
	private Integer hostFirstNotificationDelay;

	@Column(name = "host_stalking_options")
	private String hostStalkingOptions;

	@Column(name = "host_snmp_community")
	private String hostSnmpCommunity;

	@Column(name = "host_snmp_version")
	private String hostSnmpVersion;

	@Column(name = "host_location")
	private Integer hostLocation;

	@Column(name = "host_comment", columnDefinition = "TEXT")
	private String hostComment;

	@Column(name = "geo_coords")
	private String geoCoords;

	@Column(name = "host_register")
	private String hostRegister;

	@Column(name = "host_activate")
	private String hostActivate;

	@ManyToMany
	@JoinTable(name = "host_service_relation", joinColumns = @JoinColumn(name = "host_host_id"), inverseJoinColumns = @JoinColumn(name = "service_service_id"))
	private Set<Service> services = new HashSet<>(0);

}
