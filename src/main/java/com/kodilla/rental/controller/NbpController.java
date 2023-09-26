package com.kodilla.rental.controller;

import com.google.gson.Gson;
import com.kodilla.rental.domain.Currencies;
import com.kodilla.rental.service.NbpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@RestController
@RequestMapping("/v1")
public class NbpController {
    //RestTemplate restTemplate = new RestTemplate();
    NbpService service = new NbpService();

    @GetMapping("/currencies")
    public List<Currencies> getCurriences() {
        return service.getCurrenciesList();
    }
}
