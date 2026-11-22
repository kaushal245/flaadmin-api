package com.webelement.flaadmin.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webelement.flaadmin.dto.BankDTO;

public interface BankService {
	public Page<BankDTO> getBankList(Pageable pageable, String search);
	public Optional<BankDTO> getBankById(Integer bankId);
}
