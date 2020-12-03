package com.g2academy.bookstore.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouses")
@Audited
@AuditTable("warehouse_audit")
public class Warehouse extends BaseEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	Integer code;
	String address;
	String phone;
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<WarehouseBook> warehouseBooks;
	public void addItem(WarehouseBook Item) {
		// TODO Auto-generated method stub
		if (warehouseBooks == null) this.warehouseBooks = new HashSet<>();
		this.warehouseBooks.add(Item);
		Item.setWarehouse(this);
	}
	
////    public void addWHBook (WarehouseBook warehouseBook){
////        if (warehouseBooks == null) this.warehouseBooks = new HashSet<>();
////        this.warehouseBooks.add(warehouseBook);
////        warehouseBook.setWarehouse(this);
//    }

}
