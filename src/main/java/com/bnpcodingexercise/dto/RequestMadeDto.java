package com.bnpcodingexercise.dto;

import javax.validation.constraints.NotNull;

public class RequestMadeDto {

	@NotNull
	private int id;

	@NotNull
	private String stringToValidate;

	@NotNull
	private String userName;

	@NotNull
	private String usedSymbols;

	@NotNull
	private String resultValidation;
	
	public RequestMadeDto(@NotNull int id, @NotNull String stringToValidate, @NotNull String userName,
			@NotNull String usedSymbols, @NotNull String resultValidation) {
		super();
		this.id = id;
		this.stringToValidate = stringToValidate;
		this.userName = userName;
		this.usedSymbols = usedSymbols;
		this.resultValidation = resultValidation;
	}

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
	
}
