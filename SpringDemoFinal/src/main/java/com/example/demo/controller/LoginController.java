package com.example.demo.controller;

import com.example.demo.entity.Books;
import com.example.demo.entity.Media;
import com.example.demo.service.BooksServiceImplementation;
import com.example.demo.service.MediaServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    private final BooksServiceImplementation booksServiceImplementation;
    private List<Books> booksList;
    private MediaServiceImplementation mediaServiceImplementation;
    private List<Media> mediaList;
    public LoginController(BooksServiceImplementation booksServiceImplementation,MediaServiceImplementation mediaServiceImplementation) {
        this.booksServiceImplementation = booksServiceImplementation;
        this.mediaServiceImplementation=mediaServiceImplementation;
    }

    @GetMapping("/showMyLoginPage")
    public String main() {
        return "login";
    }

    @GetMapping("/")
    public String welcome()
    {
        return "home";
    }

    @GetMapping("/booksForStudents")
    public String booksForStudents(Model theModel)
    {
        booksList=booksServiceImplementation.findAll();
        theModel.addAttribute("books",booksList);
        return "list-books";
    }
    @GetMapping("/mediaForStudents")
    public String mediaForStudents(Model theModel)
    {
        mediaList=mediaServiceImplementation.findAll();
        theModel.addAttribute("media",mediaList);
        return "list-media";
    }
    @GetMapping("/access-denied")
    public String accessDenied()
    {
        return "access-denied";
    }

}