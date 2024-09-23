package com.blog.api.utilities;

import java.util.List;

import com.blog.api.dto.PostDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse {

	private List<PostDto>content;
	private int pageNumber;
	private int pageSize;
	private long totalElemnets;
	private int totalPages;
	private boolean lastPage;
}
