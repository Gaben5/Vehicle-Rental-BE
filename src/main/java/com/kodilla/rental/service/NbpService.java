package com.kodilla.rental.service;

import com.kodilla.rental.domain.Currencies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NbpService {

    RestTemplate restTemplate = new RestTemplate();
    String urlCurrencies = "http://api.nbp.pl/api/exchangerates/tables/a/";
    public List<Currencies> getCurrenciesList() {
        Object[] result = restTemplate.getForObject(urlCurrencies, Object[].class);
        List<Currencies> currenciesList;
        List<Object> list = Arrays.asList(Objects.requireNonNull(result));
        LinkedHashMap<String, Object> o1 = (LinkedHashMap<String, Object>) list.get(0);
        List<LinkedHashMap<String, Object>> rates = (List<LinkedHashMap<String, Object>>) o1.get("rates");

        currenciesList = rates.stream()
                .map(test -> new Currencies((String) test.get("code"), (double) test.get("mid")))
                .collect(Collectors.toList());
        return currenciesList;
    }
}
