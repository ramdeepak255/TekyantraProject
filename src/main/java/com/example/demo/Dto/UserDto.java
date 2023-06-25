package com.example.demo.Dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long user_id;
    private String username;
    private String password;
    private String email;
    private LocalDate user_createdDate;
    
}
