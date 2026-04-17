package com.eniac.coinTranslate;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ConversorController {

    @GetMapping("/converter")
    public double converter(
            @RequestParam double valor,
            @RequestParam String moeda) {

        double cotacao = 0;

        switch (moeda.toLowerCase()) {
            case "dolar":
                cotacao = 5.0;
                break;
            case "euro":
                cotacao = 5.5;
                break;
            case "libra":
                cotacao = 6.3;
                break;
            default:
                return 0;
        }

        return valor / cotacao;
    }
}