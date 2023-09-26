package com.kodilla.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID", unique = true)
    private Long id;
    @Column(name = "COST")
    private BigDecimal cost;
    @Column(name = "CREATED")
    private LocalDate created;
    @Column(name = "DAYS")
    private int days;
    @Column(name = "DATE_FROM")
    private LocalDate dateFrom;
    @Column(name = "DATE_TO")
    private LocalDate dateTo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

}
