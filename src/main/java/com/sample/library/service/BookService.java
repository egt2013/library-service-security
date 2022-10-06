package com.sample.library.service;


import com.sample.library.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAll();

    BookDto save(BookDto dto);

    BookDto update(Integer id, BookDto dto);

    void delete(Integer id);

    BookDto findById(Integer id);
}
