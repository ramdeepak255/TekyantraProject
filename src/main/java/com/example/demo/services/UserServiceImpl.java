package com.example.demo.services;

import java.util.List;

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
import com.example.demo.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

     @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) 
    {
        User user=userDtoToEntity(userDto);
        User savedUser=userRepository.save(user);
        return entityToUserDto(savedUser);
        //throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }


    @Override
    public UserDto getUser(long userid) {
        User user=userRepository.findById(userid).orElseThrow(
            ()->new UserNotFound(String.format("User Id %d not found", userid))
        );
        return modelMapper.map(user,UserDto.class);
    }


    private User userDtoToEntity(UserDto userDto) 
    {
        User user=new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setUser_createdDate(userDto.getUser_createdDate());

        return user;
    }

    private UserDto entityToUserDto(User savedUser)
    {
        UserDto userDto=new UserDto();
        userDto.setUser_id(savedUser.getUser_id());
        userDto.setEmail(savedUser.getEmail());
        userDto.setUsername(savedUser.getUsername());
        userDto.setPassword(savedUser.getPassword());
        userDto.setUser_createdDate(savedUser.getUser_createdDate());

        return userDto;
    }
}
