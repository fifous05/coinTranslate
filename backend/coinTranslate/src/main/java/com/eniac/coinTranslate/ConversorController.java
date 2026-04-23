package com.eniac.coinTranslate;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ConversorController {

    private final CurrencyService currencyService;

    public ConversorController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/converter")
    public double converter(
            @RequestParam double valor,
            @RequestParam String moeda) {

        double cotacao = currencyService.getRate(moeda);

        return valor * cotacao;
    }
}