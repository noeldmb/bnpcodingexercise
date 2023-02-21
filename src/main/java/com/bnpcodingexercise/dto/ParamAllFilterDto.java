package com.bnpcodingexercise.dto;

import javax.validation.constraints.NotNull;

public class ParamAllFilterDto {

	@NotNull
	private String result;
	@NotNull
	private String username;
	@NotNull
	private BracketSymbolsDto bracketSymbols;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
