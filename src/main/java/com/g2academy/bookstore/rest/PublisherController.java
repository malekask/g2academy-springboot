package com.g2academy.bookstore.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g2academy.bookstore.models.Publisher;
import com.g2academy.bookstore.service.dto.PublisherDto;
import com.g2academy.bookstore.services.PublisherService;

@RestController
public class PublisherController {

	private final PublisherService publisherService;

	public PublisherController(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	@GetMapping("/publishers")
	public List<Publisher> getAllPublisher() {
		return publisherService.findAll();
	}

	@PostMapping("/ppublishers")
	public PublisherDto createPublisher(@RequestBody @Valid PublisherDto publisherDto) {
		Publisher entity = publisherService.add(publisherDto);
		return publisherDto;
	}

	@GetMapping("/publishers/{id}")
	public Optional<Publisher> getOnePublisher(@PathVariable Long id) {
		return publisherService.findById(id);
	}

	@PutMapping("/publishers/{id}")
	public Publisher editAuthor(@PathVariable Long id, @RequestBody @Valid PublisherDto publisherDto) {
		return publisherService.edit(id, publisherDto);
	}

	@DeleteMapping("/publishers/{id}")
	public void deletePublisher(@PathVariable Long id) {
		publisherService.delete(id);

	}
}
