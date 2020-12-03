package com.g2academy.bookstore.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2academy.bookstore.models.Author;
import com.g2academy.bookstore.models.Book;
import com.g2academy.bookstore.service.dto.AuthorDto;
import com.g2academy.bookstore.service.dto.BookDto;
import com.g2academy.bookstore.services.AuthorService;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@GetMapping("/authors")
	public ResponseEntity<List<AuthorDto>> getAllAuthors() {
		return authorService.findAllauthor();
	}

	@GetMapping("/authors/{id}")
	public ResponseEntity<AuthorDto> findAuthorById(@PathVariable(value = "id") Long id) {
		return authorService.findById(id);
	}

	@PostMapping("/authors")
	public Author add(@RequestBody AuthorDto authorDto) {
		return authorService.add(authorDto);

	}

	@PutMapping("/authors/{id}")
	public ResponseEntity<AuthorDto> editAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
		return authorService.editAuthor(id, authorDto);
	}

	@DeleteMapping("/authors/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
		return authorService.deleteAuthor(id);

	}

	@PostMapping("/authors/books/{id}")
	public Book addBook(@RequestBody BookDto bookDto, @PathVariable Long id) {
		return authorService.addBook(bookDto, id);

	}

	@PutMapping("/authors/books/{id}")
	public ResponseEntity<BookDto> editBook(@RequestBody BookDto bookDto, @PathVariable Long id) {
		return authorService.edit(bookDto, id);

	}

	@DeleteMapping("/authors/delbook/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id) {
		return authorService.deleteBook(id);

	}

}
