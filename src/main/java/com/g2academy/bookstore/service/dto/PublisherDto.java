package com.g2academy.bookstore.service.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PublisherDto {
	
	Long id;
	String name;
	String address;
	String phone;
	String url;
	private Set<BookDto> books;

}
