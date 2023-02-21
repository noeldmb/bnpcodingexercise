package com.bnpcodingexercise.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnpcodingexercise.dto.BracketSymbolsDto;
import com.bnpcodingexercise.dto.ParamAllFilterDto;
import com.bnpcodingexercise.dto.ParamValidateStringDto;
import com.bnpcodingexercise.dto.RequestMadeDto;
import com.bnpcodingexercise.service.RequestMade;
import com.bnpcodingexercise.tool.StringResources;

@RestController
@RequestMapping("/")
@CrossOrigin
public class StringController {

	@Autowired
	RequestMade requestMade;

	@PostMapping("bracket-service/validate")
	public ResponseEntity<String> validateString(@Valid @RequestBody ParamValidateStringDto params) {

		if (StringResources.checkParams(params)) {
			if (requestMade.validateString(params).equals(StringResources.VALID)) {
				return new ResponseEntity<String>(StringResources.VALID, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(StringResources.NOT_VALID, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<String>(StringResources.NOT_VALID_PARAMS, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("stringuser")
	public ResponseEntity<List<RequestMadeDto>> getStringByUser(@RequestParam("username") String userName) {
		return new ResponseEntity<List<RequestMadeDto>>(requestMade.getStringByUser(userName), HttpStatus.OK);
	}

	@GetMapping("stringresult")
	public ResponseEntity<List<RequestMadeDto>> getStringByResult(@RequestParam("result") String result) {
		return new ResponseEntity<List<RequestMadeDto>>(requestMade.getStringByResult(result), HttpStatus.OK);
	}

	@GetMapping("stringbrackets")
	public ResponseEntity<List<RequestMadeDto>> getStringByBrackets(@Valid @RequestBody BracketSymbolsDto brackets) {
		return new ResponseEntity<List<RequestMadeDto>>(requestMade.getStringByBrackets(brackets), HttpStatus.OK);
	}

	@GetMapping("stringall")
	public ResponseEntity<List<RequestMadeDto>> getStringAll() {
		return null;
	}

	@GetMapping("stringallfilters")
	public ResponseEntity<List<RequestMadeDto>> getStringAllFilters(@Valid @RequestBody ParamAllFilterDto params) {
		return new ResponseEntity<List<RequestMadeDto>>(requestMade.getStrngAllFilters(params),
				HttpStatus.OK);
	}
}
