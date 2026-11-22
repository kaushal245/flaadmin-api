package com.webelement.flaadmin.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webelement.flaadmin.common.ResponseApi;
import com.webelement.flaadmin.dto.CaptchaDto;
import com.webelement.flaadmin.dto.ChangePassWordDTO;
import com.webelement.flaadmin.dto.LoginRequest;
import com.webelement.flaadmin.dto.LoginResponse;

import com.webelement.flaadmin.service.AuthService;
import com.webelement.flaadmin.service.CaptchaService;
import com.webelement.flaadmin.service.impl.ChangePasswordImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;
	private final CaptchaService captchaService;
	private final ChangePasswordImpl changePasswordService;
	
	private Boolean isManager = false;


	@GetMapping("/captcha")
	public ResponseEntity<ResponseApi<Map<String, String>>> generateCaptcha() throws IOException {
	    return ResponseEntity.ok(new ResponseApi<>(true, "CAPTCHA Generated", captchaService.create()));
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseApi<LoginResponse>> checkLogin(@RequestBody LoginRequest request ) throws Exception {
		ResponseEntity<ResponseApi<LoginResponse>> loginResponse = authService.login(request);
		return loginResponse;
	}

	@PostMapping("/forgot-password-mail")
	public ResponseEntity<ResponseApi<String>> forgotpasswordMail(@RequestParam String emailId,@RequestParam String loginType) throws Exception {
		isManager = false;
		return authService.forgotpasswordMail(emailId, isManager, loginType);
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<ResponseApi<String>> forgotpassword(@RequestParam String emailId, @RequestParam String userId,
			@RequestParam String password, @RequestParam(required = false) String isManagerLogin) throws Exception {
		return authService.forgotpassword(emailId, userId, password, isManagerLogin);
	}

	@PostMapping("/change-password")
	public ResponseEntity<ResponseApi<String>> changePassword(@RequestBody ChangePassWordDTO request) {

		String message = changePasswordService.changePassword(request);
		return ResponseEntity.ok(new ResponseApi<String>(true, message, null));
	}
}
