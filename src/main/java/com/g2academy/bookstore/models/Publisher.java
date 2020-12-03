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
@Table(name = "publishers")
@Audited
@AuditTable ("publishers_audit")
public class Publisher extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String address;
	String phone;
	String url;
	
	 @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private Set<Book> books;

		public void addItem(Book item) {
			// TODO Auto-generated method stub
			if(this.books == null ) this.books = new HashSet<>();
			this.books.add(item);
			item.setPublisher(this);
		}

}
