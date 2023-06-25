package com.example.demo.Dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
       private long isbn;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedDate;
    private String genre;

}
