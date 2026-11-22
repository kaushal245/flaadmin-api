package com.webelement.flaadmin.service.impl;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.webelement.flaadmin.Exceptions.PasswordValidationException;
import com.webelement.flaadmin.common.CommonFunction;
import com.webelement.flaadmin.dto.ChangePassWordDTO;
import com.webelement.flaadmin.jwttoken.AppUser;
import com.webelement.flaadmin.jwttoken.CurrentUser;
import com.webelement.flaadmin.repo.UserLoginRepository;
import com.webelement.flaadmin.service.ChangePassword;
import com.webelement.flaadmin.service.PasswordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChangePasswordImpl implements ChangePassword {

	private final UserLoginRepository userReposatroy;
	
	private final CommonFunction commonFunction;
	private final PasswordService passwordService;
	
	@Override
	@Transactional
	public String changePassword(ChangePassWordDTO request) {
	    validateChangePasswordRequest(request);

	    AppUser me = CurrentUser.get();            // identity comes from the token

	    String oldPassword;
	    String newPassword;
	    try {
	        oldPassword = commonFunction.decipher(request.getOldPassword());
	        newPassword = commonFunction.decipher(request.getNewPassword());
	    } catch (Exception e) {
	        throw new PasswordValidationException("Invalid encrypted request data.", e);
	    }
	    validateNewPassword(oldPassword, newPassword);

	    String stored = userReposatroy.findPasswordByUserId(me.getUserId());
	    if (!passwordService.matches(oldPassword, stored)) {
	        throw new PasswordValidationException("Old password is incorrect.");
	    }

	    int rows = userReposatroy.updateForgotPassword(me.getUserId(), passwordService.hash(newPassword), null);
	    if (rows != 1) {
	        throw new IllegalStateException("Password update failed. Please try again.");
	    }
	    return "Password changed successfully.";
	}



	private void validateChangePasswordRequest(ChangePassWordDTO request) {
		if (request == null) {
			throw new PasswordValidationException("Request cannot be null.");
		}
		if (isBlank(request.getUsername())) {
			throw new PasswordValidationException("Email ID is required.");
		}
		if (isBlank(request.getOldPassword())) {
			throw new PasswordValidationException("Old password is required.");
		}
		if (isBlank(request.getNewPassword())) {
			throw new PasswordValidationException("New password is required.");
		}
	}

	private void validateDecryptedValues(String emailId, String oldPassword, String newPassword) {
		if (isBlank(emailId) || isBlank(oldPassword) || isBlank(newPassword)) {
			throw new PasswordValidationException("Invalid email or password details.");
		}
	}

	private void validateNewPassword(String oldPassword, String newPassword) {
		if (newPassword.length() < 8) {
			throw new PasswordValidationException("New password must contain at least 8 characters.");
		}
		if (oldPassword.equals(newPassword)) {
			throw new PasswordValidationException("New password must be different from the old password.");
		}
	}

	private boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

}
