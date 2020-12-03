package com.g2academy.bookstore.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
@Audited
@AuditTable("authors_audit")
public class Author extends BaseEntity {

	String name;
	String address;
	String url;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)

	private Set<Book> books;

	public void addItem(Book item) {
		// TODO Auto-generated method stub
		if (this.books == null)
			this.books = new HashSet<>();
		this.books.add(item);
		item.setAuthor(this);
	}

	public Long getAuthorId() {
		// TODO Auto-generated method stub
		return id;
	}

}
