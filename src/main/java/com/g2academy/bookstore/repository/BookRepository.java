package com.g2academy.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.g2academy.bookstore.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE b.isbn LIKE %?1%")
	List<Book> findBookByISBN(String keyword);
	@Query("SELECT b FROM Book b WHERE b.isbn LIKE %?1%")
	List<Book> findBookByTitle(String keyword);






}
