package com.g2academy.bookstore.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g2academy.bookstore.service.dto.BookDto;
import com.g2academy.bookstore.services.BookService;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getAllBooks() {

		return bookService.findAllbook();
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BookDto> findBookById(@PathVariable(value = "id") Long id) {

		return bookService.findBookById(id);
	}

	@GetMapping("/books/search/isbn")
	public ResponseEntity<List<BookDto>> findBookByISBN(@RequestParam(value = "isbn") String isbn) {
		return bookService.findBookByISBN(isbn);
	}

	@GetMapping("/books/search/title")
	public ResponseEntity<List<BookDto>> findBookByTitle(@RequestParam(value = "title") String title) {
		return bookService.findBookByTitle(title);
	}

	@GetMapping("/books/author/{name}")
	public ResponseEntity<List<BookDto>> findBookByAuthorName(@RequestParam(value = "name") String name) {
		return bookService.findBookByAuthorName(name);
	}
	@GetMapping("/books/publisher/{name}")
	public ResponseEntity<List<BookDto>> findBookBypublisherName(@RequestParam(value = "name") String name) {
		return bookService.findBookBypublisherName(name);
	}
}
