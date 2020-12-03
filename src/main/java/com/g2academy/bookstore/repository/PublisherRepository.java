package com.g2academy.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.g2academy.bookstore.models.Book;
import com.g2academy.bookstore.models.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
	@Query("SELECT b FROM Book b WHERE b.isbn LIKE %?1%")
	List<Book> findBookByPublisherName(String keyword);



	

}
