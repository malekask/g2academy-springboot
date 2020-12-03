package com.g2academy.bookstore.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.g2academy.bookstore.models.Author;
import com.g2academy.bookstore.service.dto.AuthorDto;

@Mapper(uses = BookMapper.class)
public interface AuthorMapper {

	AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

	AuthorDto toDto(Author author);

	

	List<AuthorDto> toDtos(List<Author> authors);

	Author toAuthor (AuthorDto authorDto);
}
