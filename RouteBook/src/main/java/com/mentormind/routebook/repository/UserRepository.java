package com.mentormind.routebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mentormind.routebook.entity.User;


public interface UserRepository  extends JpaRepository<User, Integer>{
    User findByEmail(String email);

}