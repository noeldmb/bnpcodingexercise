package com.bnpcodingexercise.service;

import java.util.List;

import javax.validation.Valid;

import com.bnpcodingexercise.dto.BracketSymbolsDto;
import com.bnpcodingexercise.dto.ParamAllFilterDto;
import com.bnpcodingexercise.dto.ParamValidateStringDto;
import com.bnpcodingexercise.dto.RequestMadeDto;

public interface RequestMade {

	String validateString(@Valid ParamValidateStringDto params);

	List<RequestMadeDto> getStringByUser(String userName);

	List<RequestMadeDto> getStringByResult(String result);

	List<RequestMadeDto> getStringByBrackets(@Valid BracketSymbolsDto brackets);

	List<RequestMadeDto> getStrngAllFilters(ParamAllFilterDto params);

}
