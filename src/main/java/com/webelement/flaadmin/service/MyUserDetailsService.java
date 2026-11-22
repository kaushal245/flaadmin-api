package com.webelement.flaadmin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webelement.flaadmin.dto.LoginRequest;
import com.webelement.flaadmin.entity.UserLoginEntity;
import com.webelement.flaadmin.jwttoken.AppUser;
import com.webelement.flaadmin.repo.UserLoginRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserLoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadAppUser(username, "other");
    }

    public AppUser loadAppUser(String username, String loginType) {
        UserLoginEntity u = loginRepository.findByEmailAndStatus(username, 1)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        boolean admin = "Y".equalsIgnoreCase(u.getPermission());


        List<GrantedAuthority> auth = new ArrayList<>();
        if (admin) auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
 

        return new AppUser(u.getEmail(), auth, u.getUserId(), loginType, admin, admin);
    }
}