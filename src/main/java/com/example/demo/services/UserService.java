package com.example.demo.services;

import com.example.demo.Dto.UserDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;

//import antlr.collections.List;
import java.util.List;

public interface UserService {

    public UserDto createUser(UserDto userDto);

    public UserDto getUser(long userid);
}
