package com.eniac.coinTranslate.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {

    public double getRate(String moeda) {
        try {
            String url = "https://api.exchangerate-api.com/v4/latest/BRL";

            RestTemplate restTemplate = new RestTemplate();
            Map response = restTemplate.getForObject(url, Map.class);

            if (response == null) {
                throw new RuntimeException("Resposta da API é null");
            }

            Map rates = (Map) response.get("rates");

            if (rates == null) {
                throw new RuntimeException("Rates não encontrados");
            }

            switch (moeda.toLowerCase()) {
                case "dolar":
                    return Double.parseDouble(rates.get("USD").toString());
                case "euro":
                    return Double.parseDouble(rates.get("EUR").toString());
                case "libra":
                    return Double.parseDouble(rates.get("GBP").toString());
                default:
                    throw new RuntimeException("Moeda inválida");
            }

        } catch (Exception e) {
            e.printStackTrace(); // 👈 MOSTRA O ERRO REAL
            return 0;
        }
    }
}