package com.bnpcodingexercise.dto;

import javax.validation.constraints.NotNull;

public class BracketSymbolsDto {

	@NotNull
	private String open;
	@NotNull
	private String close;

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}
}
