package com.blog.api.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	private static final FetchType LAZY = null;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 1l;
	@Column(name="Title",length=100,nullable=false)
	private String categoryTitle;
	@Column(name="description")
	private String categoryDescription;

	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Post>post=new ArrayList();
}
