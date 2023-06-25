package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

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
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.createUser(userDto),HttpStatus.CREATED);
    }

      @GetMapping("api/users/{userid}")
    public ResponseEntity<UserDto> getUser(
        @PathVariable(name="userid") long userid)
    {
        return new ResponseEntity<>(userService.getUser(userid),HttpStatus.OK);
    }



    // @Autowired
    // UserRepository userRepository;

    
    // @GetMapping("/api/users")
    // public ResponseEntity<List<User>> getUsers()
    // {
    //     return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    // }

    // @GetMapping("/api/users/{id}")
    // public ResponseEntity<User> getUser(@PathVariable long id)
    // {
    //     Optional<User> user=userRepository.findById(id);
    //     if(user.isPresent())
    //     {
    //         return new ResponseEntity<>(user.get(),HttpStatus.OK);
    //     }
    //     else
    //     {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @PutMapping("api/users/{id}")
    // public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User userMember)
    // {
    //     Optional<User> user=userRepository.findById(id);
    //     if(user.isPresent())
    //     {
    //         user.get().setUsername(userMember.getUsername());
    //         user.get().setPassword(userMember.getPassword());
    //         user.get().setEmail(userMember.getEmail());

    //         return new ResponseEntity<>(userRepository.save(user.get()),HttpStatus.OK);
    //     }
    //     else
    //     {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @DeleteMapping("/api/users/{id}")
    // public ResponseEntity<Void> deleteUser(@PathVariable long id)
    // {
    //     Optional<User> user=userRepository.findById(id);
    //     if(user.isPresent())
    //     {
    //         userRepository.deleteById(id);
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     }
    //     else
    //     {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }
    // public ResponseEntity<User> deleteUser(String AuthToken,@RequestBody User user)
    // {
    //     return new ResponseEntity<>(userRepository.deleteById(user),HttpStatus.CREATED);
    // }
}
