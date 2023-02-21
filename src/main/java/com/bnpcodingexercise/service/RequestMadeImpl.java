package com.bnpcodingexercise.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpcodingexercise.dto.BracketSymbolsDto;
import com.bnpcodingexercise.dto.ParamAllFilterDto;
import com.bnpcodingexercise.dto.ParamValidateStringDto;
import com.bnpcodingexercise.dto.RequestMadeDto;
import com.bnpcodingexercise.entity.RequestMadeEntity;
import com.bnpcodingexercise.repository.RequestMadeRepository;
import com.bnpcodingexercise.tool.StringResources;

@Service
@Transactional
public class RequestMadeImpl implements RequestMade {

	@Autowired
	RequestMadeRepository requestMadeRepository;

	@Override
	public String validateString(@Valid ParamValidateStringDto params) {
		String resp = StringResources.NOT_VALID;
		if (validString(params).equals(StringResources.VALID))
			resp = StringResources.VALID;

		persistingValidationResult(params, resp);
		return resp;
	}

	@Override
	public List<RequestMadeDto> getStringByUser(String userName) {
		return requestMadeRepository.findByUserName(userName).orElse(new ArrayList<>());
	}

	@Override
	public List<RequestMadeDto> getStringByResult(String result) {
		return requestMadeRepository.findByResultValidation(result).orElse(new ArrayList<>());
	}

	@Override
	public List<RequestMadeDto> getStringByBrackets(@Valid BracketSymbolsDto params) {
		String brackets = params.getOpen().trim() + params.getClose().trim();
		return requestMadeRepository.findByUsedSymbols(brackets).orElse(new ArrayList<>());
	}

	@Override
	public List<RequestMadeDto> getStrngAllFilters(ParamAllFilterDto params) {
		String openBracket = params.getBracketSymbols().getOpen().trim();
		String closeBracket = params.getBracketSymbols().getClose().trim();

		return requestMadeRepository.getStrngAllFilters(params.getUsername(), params.getResult(),
				openBracket.concat(closeBracket));
	}

	private String validString(ParamValidateStringDto params) {
		boolean resp = StringResources.validBraketsInString(params);

		if (resp) {
			return StringResources.VALID;
		} else {
			return StringResources.NOT_VALID;
		}
	}

	private void persistingValidationResult(@Valid ParamValidateStringDto params, String resultValidation) {
		RequestMadeEntity requestMadeNew = new RequestMadeEntity();

		requestMadeNew.setResultValidation(resultValidation);
		requestMadeNew.setStringToValidate(params.getString());
		requestMadeNew.setUsedSymbols(
				params.getBracketSymbols().getOpen().trim() + params.getBracketSymbols().getClose().trim());
		requestMadeNew.setUserName(params.getUsername());

		requestMadeRepository.save(requestMadeNew);
	}

//	public boolean checkParams(ParamValidateStringDto params) {
//		boolean resp = true;
//		String openBracket = params.getBracketSymbols().getOpen();
//		String closeBracket = params.getBracketSymbols().getClose();
//
//		if (openBracket == null || openBracket.isEmpty() || closeBracket == null || closeBracket.isEmpty()
//				|| params.getString() == null || params.getString().isEmpty() || params.getUsername() == null
//				|| params.getUsername().isEmpty())
//			resp = false;
//
//		return resp;
//	}
}
