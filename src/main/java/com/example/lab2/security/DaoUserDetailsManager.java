package com.example.lab2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.lab2.entity.User;
import com.example.lab2.repository.UserDAO;
@Service
public class DaoUserDetailsManager implements UserDetailsService{
    @Autowired
    UserDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản!"));
                
        String password = user.getPassword();
        
        String[] roles = user.getUserRoles().stream()
                .map(ur -> ur.getRole().getId().substring(5))
                .toList().toArray(String[]::new);

        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password(password)
                .roles(roles)
                .build();
    }

}
