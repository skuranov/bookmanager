package com.firstspringapp.bookmanager.controller;

import com.firstspringapp.bookmanager.domain.Book;
import com.firstspringapp.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by zivert on 31.07.2015.
 */
@Controller
public class BookController {
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getBooks(Model model){
        List<Book> books = this.bookRepository.listAll();
        model.addAttribute("books", books);
        return "index";
    }
}
