package com.demo.security1.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
 	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws
		Exception {
		http.csrf().disable()		
			.authorizeHttpRequests().requestMatchers("/user/**").authenticated()
			.requestMatchers("/manager/**").hasAnyAuthority("ROLE_MANAGER","ROLE_ADMIN")
			.requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.loginPage("/loginForm")
			.usernameParameter("id")
			.passwordParameter("pwd")
			.loginProcessingUrl("/login/process")
			.defaultSuccessUrl("/");
					
		return http.build();
	}
}
