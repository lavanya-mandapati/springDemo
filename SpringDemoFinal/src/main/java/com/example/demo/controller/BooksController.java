package com.example.demo.controller;


import com.example.demo.Exception.IdNotFoundException;
import com.example.demo.entity.Books;
import com.example.demo.service.BooksServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    private BooksServiceImplementation booksServiceImplementation;
    private List<Books> booksList;

    public BooksController(BooksServiceImplementation booksServiceImplementation) {
        this.booksServiceImplementation = booksServiceImplementation;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Books theBook=new Books();
        theModel.addAttribute("books",theBook);
        return "book-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId")int theId,Model theModel)
    {
        Books theBooks=booksServiceImplementation.findById(theId);
        booksList=booksServiceImplementation.findAll();
        theModel.addAttribute("books",booksList);
        theModel.addAttribute("books",theBooks);

        return "book-form";
    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("books")Books theBook)
    {
        booksServiceImplementation.save(theBook);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId")int theId)
    {
        booksServiceImplementation.deleteById(theId);
        return "redirect:/";
    }
    @GetMapping("/getList")
    public String getList(Model theModel)
    {
       booksList=booksServiceImplementation.findAll();
       theModel.addAttribute("books",booksList);
       return "books-list";
    }
    @ExceptionHandler(IdNotFoundException.class)
    public String handleError(IdNotFoundException e, Model theModel) {
        theModel.addAttribute("message", e.getMessage());
        return "showError";
    }


}
