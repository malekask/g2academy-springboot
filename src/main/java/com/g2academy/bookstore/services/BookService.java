package com.g2academy.bookstore.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.g2academy.bookstore.models.Book;
import com.g2academy.bookstore.repository.AuthorRepository;
import com.g2academy.bookstore.repository.BookRepository;
import com.g2academy.bookstore.repository.PublisherRepository;
import com.g2academy.bookstore.service.dto.BookDto;
import com.g2academy.bookstore.service.mapper.BookMapper;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final PublisherRepository publisherRepository;

	public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
			PublisherRepository publisherRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
	}

	Function<List<Book>, List<BookDto>> toDtos() {
		return (x) -> BookMapper.INSTANCE.toDtos(x);
	}

	Function<Book, BookDto> toDto() {
		return (x) -> BookMapper.INSTANCE.toDto(x);
	}

	Function<List<Book>, ResponseEntity<List<BookDto>>> getAllBooks() {
		return (x) -> new ResponseEntity<List<BookDto>>(this.toDtos().apply(x), HttpStatus.OK);
	}

	Function<Book, ResponseEntity<BookDto>> getABook() {
		return (x) -> new ResponseEntity<>(this.toDto().apply(x), HttpStatus.OK);
	}

	public ResponseEntity<List<BookDto>> findAllbook() {
		return this.getAllBooks().apply(bookRepository.findAll());
	}

	public ResponseEntity<BookDto> findBookById(Long id) {
		return this.getABook().apply(bookRepository.findById(id).get());
	}

	public ResponseEntity<List<BookDto>> findBookByISBN(String isbn) {
		return this.getAllBooks().apply(bookRepository.findBookByISBN(isbn));
	}

	public ResponseEntity<List<BookDto>> findBookByTitle(String title) {
		return this.getAllBooks().apply(bookRepository.findBookByTitle(title));
	}

	public ResponseEntity<List<BookDto>> findBookByAuthorName(String name) {
		return this.getAllBooks().apply(authorRepository.findBookByAuthorName(name));
	}

	public ResponseEntity<List<BookDto>> findBookBypublisherName(String name) {
		return this.getAllBooks().apply(publisherRepository.findBookByPublisherName(name));
	}

}
