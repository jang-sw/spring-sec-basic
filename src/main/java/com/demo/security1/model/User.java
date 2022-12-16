package com.demo.security1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class User {
	
		@Id
		String id;
		String pwd;
		String role;
		
		public Boolean isEmpty() {
			if( pwd == null || id == null || "".equals(id) || "".equals(pwd) ) return true;
			else return false;		
		}
	
}
