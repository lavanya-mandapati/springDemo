package com.example.demo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="books")
public @Data
@NoArgsConstructor
class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private Integer bookId;

    @Column(name="book_name")
    private String bookName;

    @Column(name="book_author")
    private String bookAuthor;

    @Column(name="subject")
    private String subject;


    public Books(String bookName,String bookAuthor,String subject)
    {
        this.bookAuthor=bookAuthor;
        this.bookName=bookName;
        this.subject=subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookId() {
        return bookId;
    }
}
