package com.apap.finalprojectB6.service;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

public interface JwtUserDetailsService {
    UserDetails loadUserByUsername(String username);
}