package com.g2academy.bookstore.service.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorDto {

	private Long id;
	String name;
	String address;
	String url;
	private Set<BookDto> bookDtos;
	
}
