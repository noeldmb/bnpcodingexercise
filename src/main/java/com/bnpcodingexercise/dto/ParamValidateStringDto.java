package com.bnpcodingexercise.dto;

import javax.validation.constraints.NotNull;

public class ParamValidateStringDto {
	
	@NotNull
	private String string;
	@NotNull
	private String username;
	@NotNull
	private BracketSymbolsDto bracketSymbols;
	
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BracketSymbolsDto getBracketSymbols() {
		return bracketSymbols;
	}
	public void setBracketSymbols(BracketSymbolsDto bracketSymbols) {
		this.bracketSymbols = bracketSymbols;
	}

}
