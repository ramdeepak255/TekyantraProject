package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long isbn;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedDate;
    private String genre;
    // @ManyToOne
    // @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
   
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }
    // public String getAuthor() {
    //     return author;
    // }
    // public Long getUser_id() {
    //     return user_id;
    // }
    // public void setUser_id(Long user_id) {
    //     this.user_id = user_id;
    // }
    // public void setAuthor(String author) {
    //     this.author = author;
    // }
    // public String getPublisher() {
    //     return publisher;
    // }
    // public void setPublisher(String publisher) {
    //     this.publisher = publisher;
    // }
    // public long getisbn() {
    //     return isbn;
    // }
    // public void setisbn(long isbn) {
    //     this.isbn = isbn;
    // }
    // public LocalDate getPublishedDate() {
    //     return publishedDate;
    // }
    // public void setPublishedDate(LocalDate publishedDate) {
    //     this.publishedDate = publishedDate;
    // }
    // public String getGenre() {
    //     return genre;
    // }
    // public void setGenre(String genre) {
    //     this.genre = genre;
    // }
    // public Book(Long isbn, String title, String author, String publisher, LocalDate publishedDate,
    //         String genre,Long user_id) {
    //     this.isbn = isbn;
    //     this.title = title;
    //     this.author = author;
    //     this.publisher = publisher;
    //     this.publishedDate = publishedDate;
    //     this.genre = genre;
    //     // this.user_id=user_id;
    // }

    // public Book()
    // {
    //     super();
    // }
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", isbn="
                + isbn + ", publishedDate=" + publishedDate + ", genre=" + genre + "]";
    }

    
    

    // public Object getTitle() {
    //     return null;
    // }
    // public void setTitle(Object title2) {
    // }
    // public Object getAuthor() {
    //     return null;
    // }
    // public void setAuthor(Object author2) {
    // }
    // public Object getPublisher() {
    //     return null;
    // }
    // public void setPublisher(Object publisher2) {
    // }
    // public Object getPublishedDate() {
    //     return null;
    // }
    // public void setPublishedDate(Object publishedDate2) {
    // }
    // public Object getGenre() {
    //     return null;
    // }
    // public void setGenre(Object genre2) {
    // }

    // Constructors, getters, and setters
}
