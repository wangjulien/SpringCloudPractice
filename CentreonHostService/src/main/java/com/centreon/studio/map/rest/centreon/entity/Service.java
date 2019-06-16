package com.centreon.studio.map.rest.centreon.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author jwang
 *
 */
@Data
@Entity
@Table(name = "service")
public class Service {

	@Id
	@Column(name = "service_id")
	private Integer serviceId;

	@Column(name = "service_template_model_stm_id")
	private Integer serviceTemplateModelStmId;

	@Column(name = "service_description")
	private String serviceDescription;

	@Column(name = "service_alias")
	private String serviceAlias;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "service_is_volatile")
	private String serviceIsVolatile;

	@Column(name = "service_max_check_attempts")
	private Integer serviceMaxCheckAttempts;

	@Column(name = "service_normal_check_interval")
	private Integer serviceNormalCheckInterval;

	@Column(name = "service_retry_check_interval")
	private Integer serviceRetryCheckInterval;

	@Column(name = "service_active_checks_enabled")
	private String serviceActiveChecksEnabled;

	@Column(name = "service_passive_checks_enabled")
	private String servicePassiveChecksEnabled;

	@Column(name = "initial_state")
	private String initialState;

	@Column(name = "service_parallelize_check")
	private String serviceParallelizeCheck;

	@Column(name = "service_obsess_over_service")
	private String serviceObsessOverService;

	@Column(name = "service_check_freshness")
	private String serviceCheckFreshness;

	@Column(name = "service_freshness_threshold")
	private Integer serviceFreshnessThreshold;

	@Column(name = "service_event_handler_enabled")
	private String serviceEventHandlerEnabled;

	@Column(name = "service_low_flap_threshold")
	private Integer serviceLowFlapThreshold;

	@Column(name = "service_high_flap_threshold")
	private Integer serviceHighFlapThreshold;

	@Column(name = "service_flap_detection_enabled")
	private String serviceFlapDetectionEnabled;

	@Column(name = "service_process_perf_data")
	private String serviceProcessPerfData;

	@Column(name = "service_retain_status_information")
	private String serviceRetainStatusInformation;

	@Column(name = "service_retain_nonstatus_information")
	private String serviceRetainNonstatusInformation;

	@Column(name = "service_notification_interval")
	private Integer serviceNotificationInterval;

	@Column(name = "service_notification_options")
	private String serviceNotificationOptions;

	@Column(name = "service_notifications_enabled")
	private String serviceNotificationsEnabled;

	@Column(name = "contact_additive_inheritance")
	private Boolean contactAdditiveInheritance;

	@Column(name = "cg_additive_inheritance")
	private Boolean cgAdditiveInheritance;

	@Column(name = "service_inherit_contacts_from_host")
	private String serviceInheritContactsFromHost;

	@Column(name = "service_first_notification_delay")
	private Integer serviceFirstNotificationDelay;

	@Column(name = "service_stalking_options")
	private String serviceStalkingOptions;

	@Column(name = "service_comment", columnDefinition = "TEXT")
	private String serviceComment;

	@Column(name = "geo_coords")
	private String geoCoords;

	@Column(name = "command_command_id_arg", columnDefinition = "TEXT")
	private String commandCommandIdArg;

	@Column(name = "command_command_id_arg2", columnDefinition = "TEXT")
	private String commandCommandIdArg2;

	@Column(name = "service_locked")
	private Boolean serviceLocked;

	@Column(name = "service_register")
	private String serviceRegister;

	@Column(name = "service_activate")
	private String serviceActivate;

	@ManyToMany(mappedBy = "services")
	private Set<Host> hosts = new HashSet<>(0);
}
