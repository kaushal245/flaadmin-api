package com.webelement.flaadmin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webelement.flaadmin.dto.AssociationDTO;
import com.webelement.flaadmin.dto.BankDTO;
import com.webelement.flaadmin.entity.AssociationEntity;
import com.webelement.flaadmin.repo.AssociationRepo;
import com.webelement.flaadmin.service.BankUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/association/")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
@RequiredArgsConstructor
public class AssociationCategoryController {
	
	private final AssociationRepo repo;
	
	@GetMapping("/list")
	public Map<String, Object> getBankDetails() {
		List<AssociationDTO> bankPage = repo.findByStatusOrderByNameAsc((short) 1);
		Map<String, Object> response = new HashMap<>();
		response.put("data",bankPage);
		return response;
	}
}
