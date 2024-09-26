package com.blog.api.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 1l;
	@Column(name = "user_name", length = 100, nullable = false)
	private String name;

	@Column(unique = true, name = "user_email", nullable = false)
	private String email;
	@Column(name = "user_password")
	private String password;
	@Column(name = "about_user")
	private String about;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> post = new ArrayList<Post>();

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_roles",
	joinColumns=@JoinColumn(name="user_id",
	referencedColumnName = "id"
			),
	inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id")
	)
	private Set<Role> roles=new HashSet<Role>();
	
			


}
