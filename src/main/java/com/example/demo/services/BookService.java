package com.example.demo.services;

import java.util.List;

import com.example.demo.Dto.BookDto;

public interface BookService {


    public BookDto saveBook(long userid,BookDto bookDto);

    public BookDto getBook(long userid,long bookid);

    public void deleteBook(long userid,long bookid);
    
    public BookDto updateBook(long userid,long bookid,BookDto bookDto);
    
}
