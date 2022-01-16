package com.lq.book.service;

import com.lq.book.bean.Book;

import java.util.List;

/**
 * @author qili
 * @create 2022-01-16-15:05
 */
public interface BookService {
    /**
     * 查询所有图书
     * @return
     */
    List<Book> queryBooks();

    /**
     * 添加图书
     * @param book
     */
    void addBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     */
    void deleteBook(Integer id);

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 修改图书内容
     * @param book
     */
    void updateBook(Book book);
}
