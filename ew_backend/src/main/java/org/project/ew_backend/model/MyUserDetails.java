package org.project.ew_backend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetails implements UserDetails {

    private final UserDB userDB;

    public MyUserDetails(UserDB userDB) {
        this.userDB = userDB;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return userDB.getPassword();
    }

    @Override
    public String getUsername() {
        return userDB.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;   // UserDetails.super.isAccountNonExpired()
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // UserDetails.super.isAccountNonLocked()
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // UserDetails.super.isCredentialsNonExpired()
    }

    @Override
    public boolean isEnabled() {
        return true;  //UserDetails.super.isCredentialsNonExpired()
    }

}
