package com.g2academy.bookstore.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "shoppingBaskets")
@Audited
@AuditTable ("Shoppingbaskets_audit")
public class ShoppingBasket extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer shop_id;
	
	@JsonBackReference
	@ManyToOne (optional = false)

	private Customer customer;
	
	@OneToMany(mappedBy = "shoppingBasket")
	@JsonManagedReference
	private Set<ShoppingBasketBook> shoppingBasketBooks;

}
