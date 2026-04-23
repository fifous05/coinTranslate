package com.eniac.coinTranslate.controllers;

import com.eniac.coinTranslate.services.CurrencyService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class ConversorController {

        private final CurrencyService currencyService;

        public ConversorController(CurrencyService currencyService) {
                this.currencyService = currencyService;
        }

        @GetMapping("/converter")
        public Map<String, Object> converter(
                @RequestParam double valor,
                @RequestParam String moeda) {

                double cotacao = currencyService.getRate(moeda);

                return Map.of(
                        "valor_original", valor,
                        "moeda", moeda,
                        "cotacao", cotacao,
                        "resultado", valor * cotacao
                );
        }
}
