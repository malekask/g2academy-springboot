package com.g2academy.bookstore.models;

import java.io.Serializable;
import java.time.YearMonth;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "books")
@Audited
@AuditTable ("books_audit")
public class Book extends BaseEntity implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="isbn", length = 20)
	String isbn;
	
	@Column(name="publish_on", columnDefinition = "mediumint")
	@Convert(converter = YearMonthIntegerAttributeConverter.class)
	YearMonth year;
	
	@Column(name = "title")
	String title;
	@Column(name = "price", precision = 19, scale = 4)
	Double Price;
	
	@JsonBackReference
	@ManyToOne (optional = false)
    @JoinColumn(
            name = "author_id",
            nullable = false
    )
	Author author;
	
	@JsonBackReference
	@ManyToOne (optional = false)
    @JoinColumn(
            name = "publisher_id",
            nullable = false
    )
	Publisher publisher;



}
