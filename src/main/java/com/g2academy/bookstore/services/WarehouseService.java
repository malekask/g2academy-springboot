//package com.g2academy.bookstore.services;
//
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Service;
//
//import com.g2academy.bookstore.models.Warehouse;
//import com.g2academy.bookstore.models.WarehouseBook;
//import com.g2academy.bookstore.models.WarehouseBook.WarehouseBookBuilder;
//import com.g2academy.bookstore.repository.WarehouseRepository;
//import com.g2academy.bookstore.service.dto.WarehouseBookDto;
//import com.g2academy.bookstore.service.dto.WarehouseDto;
//
//@Service
//public class WarehouseService {
//
//	private final WarehouseRepository repository;
//
//	public WarehouseService(WarehouseRepository repository) {
//		this.repository = repository;
//	}
//
//	public final Warehouse save(Warehouse entity) {
//
//		return repository.save(entity);
//	}
//
//	@Transactional
//	public Warehouse add(WarehouseDto warehouseDto) {
//		Warehouse aEntity = new Warehouse();
//		aEntity.setCode(warehouseDto.getCode());
//		aEntity.setAddress(warehouseDto.getAddress());
//		aEntity.setPhone(warehouseDto.getPhone());
//
//		for (WarehouseBookDto warehouseBook : warehouseDto.getWarehouseBooks()) {
//			WarehouseBook bEntity = WarehouseBook.builder().warehouse(aEntity).count(warehouseBook.getCount());
//			aEntity.addItem(bEntity);
//		}
//		return repository.save(aEntity);
//
//	}
//
//}
