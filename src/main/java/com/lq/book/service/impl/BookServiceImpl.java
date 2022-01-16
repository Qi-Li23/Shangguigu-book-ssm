package com.lq.book.service.impl;

import com.lq.book.bean.Book;
import com.lq.book.dao.BookMapper;
import com.lq.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qili
 * @create 2022-01-16-15:06
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper mapper;

    @Override
    public List<Book> queryBooks() {
        return mapper.queryBooks();
    }

    @Override
    public void addBook(Book book) {
        mapper.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        mapper.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return mapper.queryBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        mapper.updateBook(book);
    }
}
