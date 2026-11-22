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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "t_bank")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_bankid")
	private Integer bankId;

	@Column(name = "i_type")
	private Short type;

	@Column(name = "i_associationid")
	private Integer associationId;

	@Column(name = "s_name", length = 200)
	private String name;

	@Column(name = "i_status")
	private Short status;

	@Column(name = "i_userid")
	private Integer userId;

	@Column(name = "ts_regdate")
	private Timestamp regDate;

	@Column(name = "ts_moddate")
	private Timestamp modDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "i_associationid", referencedColumnName = "i_id", insertable = false, updatable = false)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private AssociationEntity association;
}
