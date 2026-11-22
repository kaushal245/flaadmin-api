package com.webelement.flaadmin.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webelement.flaadmin.dto.ModuleDropdownProjection;
import com.webelement.flaadmin.dto.TransactionActionUserProjection;
import com.webelement.flaadmin.dto.TransactionHistoryProjection;
import com.webelement.flaadmin.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/transaction")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
@RequiredArgsConstructor
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/list")
	public ResponseEntity<Page<TransactionHistoryProjection>> getTransactionHistory(
			@RequestParam(required = false) String search, @RequestParam(defaultValue = "0") Integer moduleId,
			@RequestParam(defaultValue = "0") Integer userId,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

		Page<TransactionHistoryProjection> result = transactionService.getTransactionHistory(search, moduleId, userId,
				fromDate, toDate, page, size);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/active-modules")
	public ResponseEntity<List<ModuleDropdownProjection>> getActiveModules() {

		List<ModuleDropdownProjection> modules = transactionService.getActiveModules();

		return ResponseEntity.ok(modules);
	}

	@GetMapping("/transaction-action-users")
	public ResponseEntity<List<TransactionActionUserProjection>> getTransactionActionUsers() {

		List<TransactionActionUserProjection> users = transactionService.getTransactionActionUsers();

		return ResponseEntity.ok(users);
	}
}
