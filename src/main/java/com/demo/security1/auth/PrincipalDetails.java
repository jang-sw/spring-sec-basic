package com.demo.security1.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.security1.model.User;

public class PrincipalDetails implements UserDetails {

	User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
		collection.add(new GrantedAuthority() {			
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		
		return collection;
	}

	@Override
	public String getPassword() {
		
		return user.getPwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
