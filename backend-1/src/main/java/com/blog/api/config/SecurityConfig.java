package com.blog.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.blog.api.security.config.JwtAuthenticationFilter;
import com.blog.api.services.UserDetailsImplementation;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	JwtAuthenticationFilter jwtAuthFilter;
	
	@Bean
	@Primary
	 public UserDetailsService getUserService() {
	        return new UserDetailsImplementation();
	    }
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.
				cors(Customizer.withDefaults())
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(reg -> reg.requestMatchers("/apis/register").permitAll()
						.requestMatchers("/apis/login").permitAll()
						//.requestMatchers("/apis/users").hasRole("USER")
						//.requestMatchers("/apis/posts").hasRole("ADMIN")
						//.requestMatchers("/apis/**").permitAll()
						.anyRequest().authenticated())
				        .httpBasic(Customizer.withDefaults())
				        .formLogin(Customizer.withDefaults())			
				        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                //.httpBasic(Customizer.withDefaults())
                //.formLogin(Customizer.withDefaults())
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(getUserService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
