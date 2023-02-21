package com.bnpcodingexercise.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_request_made")
public class RequestMadeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name = "string_to_validate")
	private String stringToValidate;

	@NotNull
	@Column(name = "use_name")
	private String userName;

	@NotNull
	@Column(name = "used_symbols")
	private String usedSymbols;

	@NotNull
	@Column(name = "result_validation")
	private String resultValidation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStringToValidate() {
		return stringToValidate;
	}

	public void setStringToValidate(String stringToValidate) {
		this.stringToValidate = stringToValidate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUsedSymbols() {
		return usedSymbols;
	}

	public void setUsedSymbols(String usedSymbols) {
		this.usedSymbols = usedSymbols;
	}

	public String getResultValidation() {
		return resultValidation;
	}

	public void setResultValidation(String resultValidation) {
		this.resultValidation = resultValidation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
