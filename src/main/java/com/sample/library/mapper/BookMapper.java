package com.sample.library.mapper;

import com.sample.library.dto.BookDto;
import com.sample.library.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Mapper
public abstract class BookMapper {

    @Mapping(target = "createdDate", ignore = true)
    public abstract Book toBook(BookDto dto);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "id", source = "id")
    public abstract void toBook(Integer id,BookDto dto, @MappingTarget Book book);

    @Mapping(target = "createdDate", expression = "java(convertToDate(dto.getCreatedDate()))")
    public abstract BookDto toBookDto(Book dto);

    public abstract List<BookDto> toListBookDto(List<Book> dto);

    OffsetDateTime convertToDate(Date dateTime){
        return dateTime.toInstant()
                .atOffset(ZoneOffset.UTC);
    }
}
