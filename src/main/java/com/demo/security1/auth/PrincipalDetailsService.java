package com.demo.security1.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.security1.model.User;
import com.demo.security1.repo.UserRepo;

@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = null;
		try {
			user = userRepo.findById(username).get();
		} catch (Exception e) {
			user = null;
		}
		System.out.println(user);
		return user == null ? null : new PrincipalDetails(user);
	}

}
