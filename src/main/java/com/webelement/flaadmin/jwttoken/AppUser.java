package com.webelement.flaadmin.jwttoken;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AppUser extends User {
    private final int userId;
    private final String loginType;
    private final boolean admin;


    public AppUser(String username, Collection<? extends GrantedAuthority> authorities,
                   int userId, String loginType, boolean admin, boolean hod) {
        super(username, "", authorities);
        this.userId = userId; this.loginType = loginType; this.admin = admin;
    }
    public int getUserId() { return userId; }
    public String getLoginType() { return loginType; }
    public boolean isAdmin() { return admin; }
}
