package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.BookDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;

@RestController
public class BookController  {

    @Autowired
    private BookService bookService;

    @PostMapping("/api/books/{userid}")
    public ResponseEntity<BookDto> saveBook(@PathVariable(name="userid") 
    long userid,@RequestBody BookDto bookDto)
    {
        return new ResponseEntity<>(bookService.saveBook(userid, bookDto),HttpStatus.CREATED);
    }
    
    @GetMapping("api/{userid}/books/{bookid}")
    public ResponseEntity<BookDto> getBook(
        @PathVariable(name="userid") long userid,@PathVariable(name="bookid") long bookid)
    {
        return new ResponseEntity<>(bookService.getBook(userid,bookid),HttpStatus.OK);
    }

     @DeleteMapping("api/{userid}/books/{bookid}")
    public ResponseEntity<String> deleteBook(
        @PathVariable(name="userid") long userid,@PathVariable(name="bookid") long bookid)
    {
        bookService.deleteBook(userid, bookid);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }

    @PutMapping("api/{userid}/books/{bookid}")
    public ResponseEntity<BookDto> updateBook(
        @PathVariable(name="userid") long userid,@PathVariable(name="bookid") long bookid,@RequestBody BookDto bookDto)
    {
        // bookService.updateBook(userid, bookid,bookDto);
        return new ResponseEntity<>(bookService.updateBook(userid,bookid, bookDto),HttpStatus.OK);
    }


    // @Autowired
    // BookRepository bookRepository;

    // @PostMapping("/api/books")
    // public ResponseEntity<Book> savebook(@RequestBody Book book)
    // {
    //     return new ResponseEntity<>(bookRepository.save(book),HttpStatus.CREATED);
    // }
    // @GetMapping("/api/books")
    // public ResponseEntity<List<Book>> getbooks()
    // {
    //     return new ResponseEntity<>(bookRepository.findAll(),HttpStatus.OK);
    // }

    // @GetMapping("/api/books/{id}")
    // public ResponseEntity<Book> getbook(@PathVariable long id)
    // {
    //     Optional<Book> book=bookRepository.findById(id);
    //     if(book.isPresent())
    //     {
    //         return new ResponseEntity<>(book.get(),HttpStatus.OK);
    //     }
    //     else
    //     {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @PutMapping("api/books/{id}")
    // public ResponseEntity<Book> updatebook(@PathVariable long id,@RequestBody Book bookObject)
    // {
    //     Optional<Book> book=bookRepository.findById(id);
    //     if(book.isPresent())
    //     {
    //         book.get().setAuthor(bookObject.getAuthor());
    //         book.get().setGenre(bookObject.getGenre());
    //         book.get().setTitle(bookObject.getTitle());
    //         book.get().setPublisher(bookObject.getPublisher());
    //        // book.get().setUser_id(bookObject.getUser_id());
    //         return new ResponseEntity<>(bookRepository.save(book.get()),HttpStatus.OK);
    //     }
    //     else
    //     {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @DeleteMapping("/api/books/{id}")
    // public ResponseEntity<Void> deletebook(@PathVariable long id)
    // {
    //     Optional<Book> book=bookRepository.findById(id);
    //     if(book.isPresent())
    //     {
    //         bookRepository.deleteById(id);
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     }
    //     else
    //     {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }
    // public ResponseEntity<book> deletebook(String AuthToken,@RequestBody book book)
    // {
    //     return new ResponseEntity<>(bookRepository.deleteById(book),HttpStatus.CREATED);
    // }
}

