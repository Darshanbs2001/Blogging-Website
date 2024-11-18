package com.blog.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.blog.api.config.AppConstants;
import com.blog.api.entities.Role;
import com.blog.api.repos.RoleRepo;

@SpringBootApplication
public class Backend1Application implements CommandLineRunner {
//@Autowired
//private PasswordEncoder encoder;
	@Autowired
	private RoleRepo repo;
	@Override
	public void run(String... args) throws Exception {
		Role role1=new Role();
		role1.setId(AppConstants.NORMAL_USER);
		role1.setName("NORMAL_USER");
		Role role2=new Role();
		role2.setId(AppConstants.ADMIN_USER);
		role2.setName("ADMIN_USER");
 		
		repo.save(role1);
		repo.save(role2);
	}

	public static void main(String[] args) {
		SpringApplication.run(Backend1Application.class, args);
	}

    @Bean
    ModelMapper makeModelMapper() {
		return new ModelMapper();
	}
    

}