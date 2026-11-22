package com.webelement.flaadmin.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "t_bankuser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankUserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_bankuserid")
	private Integer bankUserId;

	@Column(name = "i_bankid")
	private Integer bankId;

	@Column(name = "s_name", length = 200)
	private String name;

	@Column(name = "s_contactno", length = 20)
	private String contactNo;

	@Column(name = "s_email", length = 200)
	private String email;

	// accepted in requests, never returned in JSON responses
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "s_password", length = 200)
	private String password;

	@Column(name = "i_status")
	private Short status;

	@Column(name = "i_userid")
	private Integer userId;

	@Column(name = "ts_regdate")
	private Timestamp regDate;

	@Column(name = "ts_moddate")
	private Timestamp modDate;

	@Column(name = "ts_sentlinkdate")
	private Timestamp sentLinkDate;

	@Column(name = "s_random", length = 10)
	private String random;
	
	
}
