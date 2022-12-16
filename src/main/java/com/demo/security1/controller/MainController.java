package com.demo.security1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.security1.constant.Constant;
import com.demo.security1.model.User;
import com.demo.security1.repo.UserRepo;

@Controller
public class MainController {

	@Autowired
	UserRepo userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public String joinForm() {
		return "joinForm";
	}
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user() {
		return "user";
	}
	@ResponseBody
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin() {
		return "admin";
	}
	@ResponseBody
	@RequestMapping(value="/manager", method=RequestMethod.GET)
	public String manager() {
		return "manager";
	}
	@ResponseBody
	@RequestMapping(value="/join/process", method=RequestMethod.POST)
	public ResponseEntity<String> joinProcess(User user) {
		try {
			if(user.isEmpty())  return new ResponseEntity<String>("something empty", HttpStatus.BAD_REQUEST);
			else {
				user.setRole(Constant.ROLE_USER); 
				user.setPwd( passwordEncoder.encode(user.getPwd()) );
				userRepo.save(user);
			}
			return new ResponseEntity<String>("<script>window.location.href='/loginForm'</script>", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Server Exception", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


}
