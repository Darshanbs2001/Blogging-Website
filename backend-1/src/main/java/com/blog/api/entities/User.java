package com.blog.api.entities;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="user_name",nullable=false)
	private String name;
	@Column(name="user_email",nullable=false)
	private String email;
	@Column(name="user_password",nullable=false)
	private String password;
	@Column(name="about_user",nullable=true)
	private String about;
	

}
