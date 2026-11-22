package com.webelement.flaadmin.service.impl;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webelement.flaadmin.Exceptions.ResourceNotFoundException;
import com.webelement.flaadmin.dto.BankDTO;
import com.webelement.flaadmin.entity.BankEntity;
import com.webelement.flaadmin.repo.BankRepo;
import com.webelement.flaadmin.service.BankService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService{
	
	private final BankRepo bankRepo;
	
	@Override
	public Page<BankDTO> getBankList(Pageable pageable, String search) {
		return bankRepo.findBankDetails(pageable, search).map(this::toDto);
	}

	@Override
	public Optional<BankDTO> getBankById(Integer bankId) {
		return bankRepo.findByBankId(bankId).map(this::toDto);
	}

	private BankDTO toDto(BankEntity b) {
		return BankDTO.builder().bankId(b.getBankId()).type(b.getType()).associationId(b.getAssociationId())
				.name(b.getName()).status(b.getStatus()).userId(b.getUserId()).regDate(b.getRegDate())
				.modDate(b.getModDate())
				.associationName(b.getAssociation() != null ? b.getAssociation().getName() : null).build();
	}
}
