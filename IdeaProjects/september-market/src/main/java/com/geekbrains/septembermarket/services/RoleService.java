package com.geekbrains.septembermarket.services;


import com.geekbrains.septembermarket.entities.Role;
import com.geekbrains.septembermarket.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(Long id) {
        return roleRepository.getRoleById(id);
    }

    public Role findRoleByName(String name) {return roleRepository.findOneByName(name);}
}
