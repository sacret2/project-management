package com.jrp.pma.entities.authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PmaUserDetails implements UserDetails {

    private String userName;
    private String email;
    private String password;
    private boolean enabled;
    private List<GrantedAuthority> authorities;

    public PmaUserDetails(UserAccount userAccount){
        this.userName = userAccount.getUserName();
        this.email = userAccount.getEmail();
        this.password = userAccount.getPassword();
        this.enabled = userAccount.isEnabled();
        this.authorities = Arrays.stream(userAccount.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        System.out.println("user details for "+userName);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getEmail() {
        return email;
    }
}
