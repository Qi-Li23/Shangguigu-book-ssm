package com.lq.book.dao;

import com.lq.book.bean.Book;

import java.util.List;

/**
 * @author qili
 * @create 2022-01-16-15:00
 */
public interface BookMapper {

    /**
     * 添加图书
     * @param book
     * @return
     */
    Integer addBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    Integer deleteBookById(Integer id);

    /**
     * 修改图书
     * @param book
     * @return
     */
    Integer updateBook(Book book);

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> queryBooks();
}
