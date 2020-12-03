package com.g2academy.bookstore.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.g2academy.bookstore.models.Author;
import com.g2academy.bookstore.models.Book;
import com.g2academy.bookstore.repository.AuthorRepository;
import com.g2academy.bookstore.repository.BookRepository;
import com.g2academy.bookstore.repository.PublisherRepository;
import com.g2academy.bookstore.service.dto.AuthorDto;
import com.g2academy.bookstore.service.dto.BookDto;
import com.g2academy.bookstore.service.mapper.AuthorMapper;
import com.g2academy.bookstore.service.mapper.BookMapper;

@Service
public class AuthorService {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepositor) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;

	}

	public final Author save(Author entity) {
		return authorRepository.save(entity);
	}

	public final Book save(Book entity) {
		return bookRepository.save(entity);
	}

	Function<List<Author>, List<AuthorDto>> toDtos() {
		return (x) -> AuthorMapper.INSTANCE.toDtos(x);
	}

	Function<Author, AuthorDto> toDto() {
		return (x) -> AuthorMapper.INSTANCE.toDto(x);
	}

	Function<List<Author>, ResponseEntity<List<AuthorDto>>> getAllAuthors() {
		return (x) -> new ResponseEntity<>(this.toDtos().apply(x), HttpStatus.OK);
	}

	Function<Author, ResponseEntity<AuthorDto>> getAuthors() {
		return (x) -> new ResponseEntity<>(this.toDto().apply(x), HttpStatus.OK);
	}

	public ResponseEntity<List<AuthorDto>> findAllauthor() {
		return this.getAllAuthors().apply(authorRepository.findAll());
	}

	public ResponseEntity<AuthorDto> findById(Long id) {
		// TODO Auto-generated method stub
		return this.getAuthors().apply(authorRepository.findById(id).get());
	}

	public ResponseEntity<AuthorDto> findAllByName(String name) {
		return this.getAuthors().apply(authorRepository.findAllByName(name));
	}

//Author
	@Transactional
	public Author add(AuthorDto authorDto) {
		Author aEntity = new Author();
		aEntity.setName(authorDto.getName());
		aEntity.setAddress(authorDto.getAddress());
		aEntity.setUrl(authorDto.getUrl());

		for (BookDto book : authorDto.getBookDtos()) {
			Book bookEntity = Book.builder().author(aEntity).isbn(book.getIsbn()).title(book.getTitle())
					.Price(book.getPrice()).year(book.getYear()).publisher(book.getPublisher()).build();
			aEntity.addItem(bookEntity);
		}
		return authorRepository.save(aEntity);

	}

	public ResponseEntity<AuthorDto> editAuthor(Long id, AuthorDto authorDto) {

		Author author = authorRepository.findById(id).orElse(null);

		if (author != null) {
			author.setName(authorDto.getName());
			author.setAddress(authorDto.getAddress());
			author.setUrl(authorDto.getUrl());
			return ResponseEntity.ok(AuthorMapper.INSTANCE.toDto(this.save(author)));

		}
		return null;
	}

	public ResponseEntity<?> deleteAuthor(Long id) {
		return authorRepository.findById(id).map(authorEntity -> {
			authorRepository.delete(authorEntity);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new RuntimeException("Authors Not Found"));
	}
	// Book

	@Transactional
	public Book addBook(BookDto bookDto, Long id) {
		Author author = authorRepository.findById(id).orElse(null);
		if (author != null) {
			Book bookEntity = Book.builder().isbn(bookDto.getIsbn()).title(bookDto.getTitle()).year(bookDto.getYear())
					.Price(bookDto.getPrice()).author(author).build();
			return bookRepository.save(bookEntity);
		}
		return null;
	}

	public ResponseEntity<BookDto> edit(BookDto bookDto, Long id) {

		Optional<Book> bEntity = bookRepository.findById(id);
		Book book = bEntity.orElse(null);
		if (book != null) {
			book.setIsbn(bookDto.getIsbn());
			book.setTitle(bookDto.getTitle());
			book.setYear(bookDto.getYear());
			book.setPrice(bookDto.getPrice());
			return ResponseEntity.ok(BookMapper.INSTANCE.toDto(this.save(book)));
		}

		return null;
	}

	public ResponseEntity<?> deleteBook(Long id) {
		return bookRepository.findById(id).map(bookE -> {
			bookRepository.delete(bookE);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new RuntimeException("Books Not Found"));
	}

}
