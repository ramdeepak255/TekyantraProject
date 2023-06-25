package com.example.demo.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.BookDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.exception.APIException;
import com.example.demo.exception.BookNotFound;
import com.example.demo.exception.UserNotFound;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto saveBook(long userid, BookDto bookDto) {
        // TODO Auto-generated method stub
        User user=userRepository.findById(userid).orElseThrow(
            ()->new UserNotFound(String.format("User Id %d not found", userid))
        );
        Book book=modelMapper.map(bookDto, Book.class);
        book.setUser(user);
        Book savedBook=bookRepository.save(book);
        return modelMapper.map(savedBook,BookDto.class);
    }

    @Override
    public BookDto getBook(long userid, long bookid) {
        User user=userRepository.findById(userid).orElseThrow(
            ()->new UserNotFound(String.format("User Id %d not found", userid))
        );
        Book book=bookRepository.findById(bookid).orElseThrow(
            ()-> new BookNotFound(String.format("Book Id %d not found", bookid))
        );

        if(user.getUser_id()!=book.getUser().getUser_id())
        {
            throw new APIException(String.format("Book Id %d not belongs to UserId %d", bookid,userid));
        }
        return modelMapper.map(book,BookDto.class);
    }

    @Override
    public void deleteBook(long userid, long bookid) {
        User user=userRepository.findById(userid).orElseThrow(
            ()->new UserNotFound(String.format("User Id %d not found", userid))
        );
        Book book=bookRepository.findById(bookid).orElseThrow(
            ()-> new BookNotFound(String.format("Book Id %d not found", bookid))
        );

        if(user.getUser_id()!=book.getUser().getUser_id())
        {
            throw new APIException(String.format("Book Id %d not belongs to UserId %d", bookid,userid));
        }

        bookRepository.deleteById(bookid);

    }

    @Override
    public BookDto updateBook(long userid, long bookid,BookDto bookDto) {
        User user=userRepository.findById(userid).orElseThrow(
            ()->new UserNotFound(String.format("User Id %d not found", userid))
        );
         Book book=modelMapper.map(bookDto, Book.class);
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setUser(user);
        Book savedBook=bookRepository.save(book);
        return modelMapper.map(savedBook,BookDto.class);
    }

    



    

    //  private Book bookDtoToEntity(BookDto bookDto) 
    // {
    //     Book book=new Book();
    //     book.setTitle(bookDto.getTitle());
    //     book.setAuthor(bookDto.getAuthor());
    //     book.setGenre(bookDto.getGenre());
    //     book.setPublisher(bookDto.getPublisher());
    //     book.setPublishedDate(bookDto.getPublishedDate());
        
    //     return book;
    // }

    // private BookDto entityToBookDto(Book savedBook)
    // {
    //     BookDto bookDto=new BookDto();
    //     bookDto.setAuthor(savedBook.getAuthor());
    //     bookDto.setIsbn(savedBook.getisbn());
    //     bookDto.setGenre(savedBook.getGenre());
    //     bookDto.setPublisher(savedBook.getPublisher());
    //     bookDto.setPublishedDate(savedBook.getPublishedDate());
    //     bookDto.setTitle(savedBook.getTitle());


    //     return bookDto;
    // }
    
    
    
}
