package com.sample.library.controller;

import com.sample.library.api.BookApi;
import com.sample.library.dto.BookDto;
import com.sample.library.service.BookService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@Setter(onMethod = @__(@Autowired))
public class BookController implements BookApi {
    public BookService bookService;

    @Override
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return new ResponseEntity(bookService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Integer id) {
        return new ResponseEntity(bookService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDto> createBook(@RequestBody @Valid BookDto bookDto) {
        return new ResponseEntity(bookService.save(bookDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Integer id, @Valid @RequestBody BookDto bookDto
    ) {
        return new ResponseEntity(bookService.update(id,bookDto), HttpStatus.OK);
    }

}
