package com.g2academy.bookstore.service.dto;



import com.g2academy.bookstore.models.Book;
import com.g2academy.bookstore.models.ShoppingBasket;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ShoppingBasketBookDto {

	Long id;
	Integer count;
	ShoppingBasket shoppingBasket;
	Book book;
}
