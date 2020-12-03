package com.g2academy.bookstore.service.dto;



import java.util.Set;

import com.g2academy.bookstore.models.Customer;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ShoppingBasketDto {

	Long id;
	Customer customer;
	private Set<ShoppingBasketBookDto> shoppingBasketBooks;
}
