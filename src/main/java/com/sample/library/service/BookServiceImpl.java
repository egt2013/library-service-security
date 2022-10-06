package com.sample.library.service;

import com.sample.library.dto.BookDto;
import com.sample.library.mapper.BookMapper;
import com.sample.library.model.Book;
import com.sample.library.repository.BookRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Setter(onMethod = @__(@Autowired))
public class BookServiceImpl implements BookService {
    private BookMapper bookMapper;
    private BookRepository bookRepository;

    @Override
    public List<BookDto> findAll() {
        return bookMapper.toListBookDto(bookRepository.findAll());
    }

    @Override
    public BookDto save(BookDto dto) {
        Book bookInDb = bookRepository.save(bookMapper.toBook(dto));
        return bookMapper.toBookDto(bookInDb);
    }

    @Override
    public BookDto update(Integer id, BookDto dto) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if(bookOpt.isPresent()){
            Book bookInDb = bookOpt.get();
            bookMapper.toBook(id,dto,bookInDb);
            return bookMapper.toBookDto(bookRepository.save(bookInDb));
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        bookOpt.ifPresent(book -> bookRepository.delete(book));

    }

    @Override
    public BookDto findById(Integer id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        return bookOpt.map(book -> bookMapper.toBookDto(book)).orElse(null);
    }
}
