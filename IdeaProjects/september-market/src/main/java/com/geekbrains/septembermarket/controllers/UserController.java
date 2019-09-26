package com.geekbrains.septembermarket.controllers;


import com.geekbrains.septembermarket.entities.Role;
import com.geekbrains.septembermarket.entities.User;
import com.geekbrains.septembermarket.repositories.UserRepository;
import com.geekbrains.septembermarket.services.RoleService;
import com.geekbrains.septembermarket.services.UserService;
import com.geekbrains.septembermarket.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserServiceImpl userServiceImpl;
//    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/registered")
    public String regConf(Model model, @ModelAttribute(name = "user") User user,
                          @RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "first_name") String first_name,
                          @RequestParam(value = "last_name") String last_name,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "phone") String phone) {
        Collection<Role> role= (Collection<Role>) roleService.findRoleByName("USER");//getRole(1L);
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRoles(role);

        userServiceImpl.save(user);
 //       userServiceImpl.addUser(user);
        model.addAttribute("user", user);
        return "index";


    }
}
