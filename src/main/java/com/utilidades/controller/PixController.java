package com.utilidades.controller;

import com.utilidades.domain.Pix;
import com.utilidades.service.PixService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
@AllArgsConstructor
public class PixController {

    private final PixService pixService;

    @PostMapping("/identificar-pix")
    public Pix identificarPIX(String input) {
       return pixService.extrairIdentificadorPIX(input);
    }
}
