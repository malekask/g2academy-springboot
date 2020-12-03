package com.g2academy.bookstore.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.g2academy.bookstore.models.Author;
import com.g2academy.bookstore.models.Book;
import com.g2academy.bookstore.service.dto.BookDto;;

@Mapper(uses = AuthorMapper.class)
public interface BookMapper {

	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

	@Mapping(target = "authorId", expression = "java(entity.getAuthor().getAuthorId())")
	@Mapping(source = "author", target = "authorId", qualifiedByName = "getAuthorId")

	@Named("getAuthorId")
	default Long authorEntityGetAuthorId(Author authorEntity) {
		return authorEntity.getAuthorId();
	}

	BookDto toDto(Book entity);

	Book toEntity(BookDto dto);

	List<BookDto> toDtos(List<Book> entities);

	List<Book> toEntities(List<BookDto> dtos);
}
