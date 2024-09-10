package com.blog.api.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	@Column(name="user_name",length=100,nullable=false)
	private String name;
	
	@Column(unique=true,name="user_email",nullable=false)
	private String email;
	@Column(name="user_password")
	private String password;
	@Column(name="about_user")
	private String about;
	

}
