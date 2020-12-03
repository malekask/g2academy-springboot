package com.g2academy.bookstore.models;

import java.io.Serializable;
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
@Table(name = "customers")
@Audited
@AuditTable ("customers_audit")
public class Customer extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String email;
	String name;
	String phone;
	String address;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<ShoppingBasket> shoppingBaskets;
	
//	public void addItem(ShoppingBasket item) {
//		// TODO Auto-generated method stub
//		if(this.shoppingBaskets == null ) this.shoppingBaskets = new HashSet<>();
//		this.shoppingBaskets.add(item);
//		item.setCustomer(this);
//	}

}
