package com.demo.security1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.security1.model.User;

public interface UserRepo extends JpaRepository<User, String> {

	public List<User> findAllById(String id);
}
