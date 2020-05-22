// package com.apap.finalprojectB6.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import javax.transaction.Transactional;

// import com.apap.finalprojectB6.model.UserModel;
// import com.apap.finalprojectB6.repository.UserRoleDB;

// import java.util.ArrayList;

// @Service
// @Transactional
// public class JwtUserDetailsServiceImpl implements JwtUserDetailsService, UserDetailsService{
//     @Autowired
//     private UserRoleDB userDb;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         UserModel user = userDb.findByUsername(username);
//         if (user == null) {
//             throw new UsernameNotFoundException(username + " doesn't exist");
//         }
//         return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//     }
// }