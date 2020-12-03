package com.g2academy.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g2academy.bookstore.models.WarehouseBook;

@Repository
public interface WarehouseBookRepository extends JpaRepository<WarehouseBook, Long>{

}
