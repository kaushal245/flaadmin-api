package com.webelement.flaadmin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webelement.flaadmin.common.ResponseApi;
import com.webelement.flaadmin.dto.UserActiveDTO;
import com.webelement.flaadmin.dto.UserInfo;
import com.webelement.flaadmin.entity.UserLoginEntity;
import com.webelement.flaadmin.repo.UserLoginRepository;
import com.webelement.flaadmin.service.UserManagementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
@RequiredArgsConstructor
public class UserManagementController {
	
	
	
	



}
