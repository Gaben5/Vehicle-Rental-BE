package com.kodilla.rental.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NbpConfig {
    @Value("http://api.nbp.pl/api/exchangerates/tables/a/")
    private String tableA;
}
