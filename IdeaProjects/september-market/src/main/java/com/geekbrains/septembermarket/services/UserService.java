package com.geekbrains.septembermarket.services;

import com.geekbrains.septembermarket.entities.Role;
import com.geekbrains.septembermarket.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
 //   User addUser();
//            (String username, String password, String first_name,
//                                 String last_name, String email, String Phone, Collection<Role> roles);

}
