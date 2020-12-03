package com.g2academy.bookstore.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.g2academy.bookstore.models.Book;
import com.g2academy.bookstore.models.Publisher;
import com.g2academy.bookstore.repository.PublisherRepository;
import com.g2academy.bookstore.service.dto.BookDto;
import com.g2academy.bookstore.service.dto.PublisherDto;

@Service
public class PublisherService {
	private final PublisherRepository repository;

	@PersistenceContext
	private EntityManager em;

	public PublisherService(PublisherRepository repository) {
		this.repository = repository;
	}

	public final Publisher save(Publisher entity) {
		return repository.save(entity);
	}

	@Transactional
	public Publisher add(PublisherDto publisherDto) {
		Publisher entity = new Publisher();
		entity.setName(publisherDto.getName());
		entity.setAddress(publisherDto.getAddress());
		entity.setPhone(publisherDto.getPhone());
		entity.setUrl(publisherDto.getUrl());

		for (BookDto book : publisherDto.getBooks()) {
			Book bookEntity = Book.builder().publisher(entity).isbn(book.getIsbn()).title(book.getTitle())
					.Price(book.getPrice()).year(book.getYear()).publisher(book.getPublisher()).build();
			entity.addItem(bookEntity);

		}
		return repository.save(entity);

	}

	public List<Publisher> findAll() {
		return repository.findAll();
	}

	public Optional<Publisher> findById(Long id) {
		return repository.findById(id);
	}

	public Publisher edit(Long id, PublisherDto publisherDto) {
		Optional<Publisher> Aentity = this.findById(id);
		Publisher entity = Aentity.orElse(null);
		if (entity != null) {
			entity.setName(publisherDto.getName());
			entity.setAddress(publisherDto.getAddress());
			entity.setPhone(publisherDto.getPhone());
			entity.setUrl(publisherDto.getUrl());
			return repository.save(entity);

		}
		return null;
	}

	public void delete(Long id) {
		repository.findById(id).map(entity -> {
			repository.delete(entity);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new NullPointerException("Publisher " + id + " not found"));
	}

}
