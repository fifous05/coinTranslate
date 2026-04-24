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
                @RequestParam String origem,
                @RequestParam String destino) {

                double taxaOrigem = currencyService.getRate(origem);
                double taxaDestino = currencyService.getRate(destino);

                // converte para BRL base e depois para destino
                double valorEmBRL = valor / taxaOrigem;
                double resultado = valorEmBRL * taxaDestino;

                return Map.of(
                        "valor_original", valor,
                        "origem", origem,
                        "destino", destino,
                        "resultado", resultado
                );
        }
        }

