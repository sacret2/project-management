package com.jrp.pma.security;

import com.jrp.pma.entities.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.Collection;
import java.util.LinkedList;

public class PmaUserDetails implements UserDetails {

    private String userName;
    private String email;
    private String password;
    private boolean enabled = true;
    private String role = "ROLE_USER";

    public PmaUserDetails(UserAccount userAccount){
        this.userName = userAccount.getUserName();
        this.email = userAccount.getEmail();
        this.password = userAccount.getPassword();
        this.enabled = userAccount.isEnabled();
        this.role = userAccount.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new LinkedList<GrantedAuthority>(){};
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled();
    }
}
