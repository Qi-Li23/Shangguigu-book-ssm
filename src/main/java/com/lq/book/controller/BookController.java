package com.lq.book.controller;

import com.lq.book.bean.Book;
import com.lq.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author qili
 * @create 2022-01-16-15:08
 */
@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        List<Book> books = bookService.queryBooks();
        model.addAttribute("books", books);
        return "manager/book_manager";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String add(Book book) {
        bookService.addBook(book);
        return "redirect:/book/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return "redirect:/book/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getEmyById(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "manager/book_edit";
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String update(Book book) {
        bookService.updateBook(book);
        return "redirect:/book/";
    }


}
