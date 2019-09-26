package com.geekbrains.septembermarket.repositories;


import com.geekbrains.septembermarket.entities.Product;
import com.geekbrains.septembermarket.entities.Role;
import com.geekbrains.septembermarket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User>{

    User findOneByUsername(String username);
    List<User> findAll();
//    @Query("INSERT a INTO users a WHERE a.username=:username, a.password=:password, a.first_name=:first_name, a.last_name=:last_name, a.email=:email, a.phone=:phone)")
//   List<User> addUser(User user);
}
