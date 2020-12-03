package com.g2academy.bookstore.service.dto;

import java.time.YearMonth;

import com.g2academy.bookstore.models.Author;
import com.g2academy.bookstore.models.Publisher;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookDto {

	Long id;
	Long authorId;
	String isbn;
	String title;
	Double price;
	YearMonth year;
	Author author;
	Publisher publisher;
}
