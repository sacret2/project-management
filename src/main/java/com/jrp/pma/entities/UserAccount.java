package com.jrp.pma.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@SequenceGenerator(name="user_account_seq", initialValue=1, allocationSize=1)
public class UserAccount {

    @Id
    @Column(name ="user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_account_seq")
    private long userId;

    @Column(name = "username")
    private String userName;

    private String email;
    private String password;
    private boolean enabled = true;
    private String role = "ROLE_USER";

    public UserAccount(){

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
