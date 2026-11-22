package com.webelement.flaadmin.dto;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankUserDTO {

	private Integer bankUserId;
	private Integer bankId;
	private String name;
	private String contactNo;
	private String email;

	// accepted in requests, never returned in JSON responses
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private Short status;
	private Integer userId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date regDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  sentLinkDate;

	private String random;

	// display only, not stored in t_bankuser (fill it from t_bank when needed)
	private String bankName;
}
