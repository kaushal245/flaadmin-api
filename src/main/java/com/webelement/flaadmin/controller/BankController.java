package com.webelement.flaadmin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webelement.flaadmin.dto.BankDTO;
import com.webelement.flaadmin.service.BankService;
import com.webelement.flaadmin.service.BankUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/bank/")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
@RequiredArgsConstructor
public class BankController {
	private final BankService bankService;

	@GetMapping("/list")
	public Map<String, Object> getBankList(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "") String search) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<BankDTO> bankPage = bankService.getBankList(pageable, search);
		Map<String, Object> response = new HashMap<>();
		response.put("data", bankPage.getContent());
		response.put("totalElements", bankPage.getTotalElements());
		return response;
	}
	
	@GetMapping("/{bankId}")
	public Map<String, Object> getBankById(@PathVariable Integer bankId) {
		Map<String, Object> response = new HashMap<>();
		response.put("data", bankService.getBankById(bankId));
		return response;
	}
}
