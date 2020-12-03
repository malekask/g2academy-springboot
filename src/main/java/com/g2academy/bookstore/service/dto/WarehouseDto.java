package com.g2academy.bookstore.service.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class WarehouseDto {

	Long id;
	Integer code;
	String address;
	String phone;
	private Set<WarehouseBookDto> warehouseBooks;
}
