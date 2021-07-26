package com.example.demo.service;


import com.example.demo.Exception.IdNotFoundException;
import com.example.demo.dao.BooksRepository;
import com.example.demo.entity.Books;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BooksServiceImplementation {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksServiceImplementation(BooksRepository theBooksRepository) {
        booksRepository = theBooksRepository;
    }
    public List<Books> findAll() {
        return booksRepository.findAll();
    }


    public Books findById(int theId) {
        return booksRepository.findById(theId).orElseThrow(()->(new IdNotFoundException("book not found "+theId)));
    }


    public void save(Books theBookId) {
            booksRepository.save(theBookId);
    }


    public void deleteById(int theId) {

        Books theBook=booksRepository.findById(theId).orElseThrow(()->(new IdNotFoundException("Book not found "+theId)));
        booksRepository.deleteById(theId);
    }
}
