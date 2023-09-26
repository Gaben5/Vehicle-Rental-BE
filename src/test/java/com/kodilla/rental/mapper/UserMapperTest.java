package com.kodilla.rental.mapper;

import com.kodilla.rental.domain.Order;
import com.kodilla.rental.domain.User;
import com.kodilla.rental.domain.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    void mapToUserDto() {
        //Given
        User user = new User(1L, "Frank", "Smith", "testEmail", LocalDate.of(2023,9,25), new ArrayList<>());
        //When
        UserDto userDto = userMapper.mapToUserDto(user);
        //Then
        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getLastname(), userDto.getLastname());
        assertEquals(user.getEmail(), userDto.getEmail());
        assertEquals(user.getDateOfBirth(), userDto.getDateOfBirth());
    }
    @Test
    void mapToUser() {
        //Given
        UserDto userDto = new UserDto(1L, "Frank", "Smith", "testEmail", LocalDate.of(2023,9,25), new ArrayList<>());
        //When
        User user = userMapper.mapToUser(userDto);
        //Then
        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getLastname(), userDto.getLastname());
        assertEquals(user.getEmail(), userDto.getEmail());
        assertEquals(user.getDateOfBirth(), userDto.getDateOfBirth());
    }

    @Test
    void mapToUserDtoList() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Frank", "Smith", "testEmail", LocalDate.of(2000,9,25), new ArrayList<>()));
        users.add(new User(2L, "Adam", "Kowalski", "test", LocalDate.of(1999,2,5), new ArrayList<>()));
        users.add(new User(3L, "Emil", "Nowak", "TestEmail1", LocalDate.of(1995,1,15), new ArrayList<>()));
        //When
        userMapper.mapToUserDtoList(users);
        //Then
        assertEquals(users.size(),3);
    }
}