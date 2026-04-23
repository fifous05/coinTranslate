package com.eniac.coinTranslate.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {

    public double getRate(String moeda) {
        String url = "https://api.exchangerate-api.com/v4/latest/BRL";

        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.getForObject(url, Map.class);

        Map rates = (Map) response.get("rates");

        switch (moeda.toLowerCase()) {
            case "dolar":
                return Double.parseDouble(rates.get("USD").toString());
            case "euro":
                return Double.parseDouble(rates.get("EUR").toString());
            case "libra":
                return Double.parseDouble(rates.get("GBP").toString());
            default:
                return 0;
        }
    }
}