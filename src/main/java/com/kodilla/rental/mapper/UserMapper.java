package com.kodilla.rental.mapper;

import com.kodilla.rental.domain.User;
import com.kodilla.rental.domain.UserDto;
import com.kodilla.rental.service.OrderDbService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    private OrderMapper orderMapper;
    private OrderDbService orderDbService;
    public UserDto mapToUserDto(User user){
        return new UserDto(user.getId(), user.getFirstName(), user.getLastname(), user.getEmail(), user.getDateOfBirth(), user.getOrders());
    }

    public User mapToUser(UserDto userDto){
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastname(), userDto.getEmail(), userDto.getDateOfBirth(), userDto.getOrders());
    }

    public List<UserDto> mapToUserDtoList(final List<User> users){
        return users.stream().map(this::mapToUserDto).collect(Collectors.toList());
    }
}
