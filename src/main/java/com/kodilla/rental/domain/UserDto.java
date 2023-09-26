package com.kodilla.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastname;
    private String email;
    private LocalDate dateOfBirth;
    private List<Order> orders;
}
