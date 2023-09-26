package com.kodilla.rental.controller;

import com.kodilla.rental.domain.User;
import com.kodilla.rental.domain.UserDto;
import com.kodilla.rental.exception.UserNotFoundException;
import com.kodilla.rental.mapper.UserMapper;
import com.kodilla.rental.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    private final UserMapper mapper;
    private final UserDbService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto){
        User user = mapper.mapToUser(userDto);
        service.saveUser(user);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "{userId}")
    public ResponseEntity<Void> removeUser(@PathVariable long userId){
        service.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(mapper.mapToUserDtoList(service.getAllUsers()));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        User user = mapper.mapToUser(userDto);
        User savedUser = service.saveUser(user);
        return ResponseEntity.ok(mapper.mapToUserDto(savedUser));
    }
    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable long userId) throws UserNotFoundException {
        return ResponseEntity.ok(mapper.mapToUserDto(service.getUser(userId)));
    }

}
