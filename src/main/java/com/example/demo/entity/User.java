package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user",uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @OneToMany(mappedBy = "user")
    // private List<Book> books;
    @Column(name="user_id",nullable = false)
    private Long user_id;
    private String username;
    private String password;
    private String email;
    private LocalDate user_createdDate;
    
    // Constructors, getters, and setters
    
    // public User() {
    //     super();// Default constructor
    // }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

      public LocalDate getUser_createdDate() {
        return user_createdDate;
    }

    public void setUser_createdDate(LocalDate user_createdDate) {
        this.user_createdDate = user_createdDate;
    }

    // public User(Long user_id, String username, String password, String email, LocalDate user_createdDate) {
    //     this.user_id = user_id;
    //     this.username = username;
    //     this.password = password;
    //     this.email = email;
    //     this.user_createdDate = user_createdDate;
    // }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
                + ", user_createdDate=" + user_createdDate + "]";
    }
    
   
}

