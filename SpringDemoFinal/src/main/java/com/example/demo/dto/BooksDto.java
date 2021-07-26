package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@AllArgsConstructor
@NoArgsConstructor
class BooksDto {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String subject;


}
