package com.kodilla.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class OrderDto {
    private Long id;
    private BigDecimal cost;
    private LocalDate created;
    private int days;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Long userId;
}
