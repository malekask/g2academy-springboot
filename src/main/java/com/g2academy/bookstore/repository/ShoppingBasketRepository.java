package com.g2academy.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g2academy.bookstore.models.ShoppingBasket;

public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long> {

}
