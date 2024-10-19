package com.blog.api.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User implements UserDetails {
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

	/*
	 * @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name="user_roles", joinColumns=@JoinColumn(name="user_id",
	 * referencedColumnName = "id" ), inverseJoinColumns
	 * = @JoinColumn(name="role_id",referencedColumnName = "id") ) private
	 * Set<Roles> roles=new HashSet<Roles>();
	 */
	/*
	 * @ManyToMany(fetch = FetchType.EAGER) List<Role> roles;
	 */
	//private String Roles;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_roles",joinColumns=@JoinColumn(name="user_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id")
	)
	
	private Set<Role> roles=new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<GrantedAuthority> authorities =this.getRoles().stream().map(role->new SimpleGrantedAuthority(role.getName())).
				collect(Collectors.toSet());
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

}
