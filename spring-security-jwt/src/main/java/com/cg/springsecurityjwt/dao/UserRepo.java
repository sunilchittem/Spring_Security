package com.cg.springsecurityjwt.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.springsecurityjwt.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String uname);
}
