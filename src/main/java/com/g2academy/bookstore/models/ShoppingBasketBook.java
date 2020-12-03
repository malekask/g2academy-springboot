package com.g2academy.bookstore.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

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
@Table(name = "shoppingBasketBooks")
@Audited
@AuditTable ("shoppingbasketBooks_audit")
public class ShoppingBasketBook extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer count;

	@ManyToOne(optional = false)
	private ShoppingBasket shoppingBasket;
	
	@OneToOne
	private Book book;

}
