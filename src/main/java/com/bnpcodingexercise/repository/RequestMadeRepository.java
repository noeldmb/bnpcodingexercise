package com.bnpcodingexercise.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bnpcodingexercise.dto.RequestMadeDto;
import com.bnpcodingexercise.entity.RequestMadeEntity;

public interface RequestMadeRepository extends JpaRepository<RequestMadeEntity, Integer>{

	Optional<List<RequestMadeDto>> findByUserName(String userName);

	Optional<List<RequestMadeDto>> findByResultValidation(String result);

	Optional<List<RequestMadeDto>> findByUsedSymbols(String brackets);

	@Query("SELECT new com.bnpcodingexercise.dto.RequestMadeDto(r.id,r.stringToValidate,r.userName,r.usedSymbols,r.resultValidation) "
			+ " FROM RequestMadeEntity r "
			+ " WHERE (r.userName = ?1 OR '' = ?1) AND (r.resultValidation = ?2 OR '' = ?2 ) AND (r.usedSymbols = ?3 OR '' = ?3) ")
	List<RequestMadeDto> getStrngAllFilters(String userName, String result, String bracket);
	
}
