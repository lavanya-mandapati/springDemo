package com.example.demo.dao;

import com.example.demo.entity.Books;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books,Integer> {

}
