package com.g2academy.bookstore.service.dto;

import com.g2academy.bookstore.models.Book;
import com.g2academy.bookstore.models.Warehouse;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class WarehouseBookDto {

	Long id;
	Integer count;
	Warehouse warehouse;
	Book book;
}
