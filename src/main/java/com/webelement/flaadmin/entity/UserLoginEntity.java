package com.webelement.flaadmin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webelement.flaadmin.dto.ModulePermissionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "t_userlogin")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_userid")
	private Integer userId;

	@Column(name = "s_firstname", length = 200)
	private String firstName;

	@Column(name = "s_mobileno", length = 100)
	private String mobileNo;

	@Column(name = "s_email", length = 200)
	private String email;

	@Column(name = "s_password", length = 200)
	private String password;

	@Column(name = "s_telephone", length = 200)
	private String telephone;

	@Column(name = "d_expirydate")
	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	@Column(name = "s_permission", length = 200)
	private String permission;

	@Column(name = "i_status")
	private Short status;

	@Column(name = "ts_regdate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp regDate;

	@Column(name = "ts_moddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp modDate;

	@Column(name = "ts_sentlinkdate")
	private Timestamp sentLinkDate;

	@Column(name = "i_qcflag")
	private Short qcFlag;

	@Column(name = "s_pcb", length = 200)
	private String pcb;
	
	
	
	
	

}