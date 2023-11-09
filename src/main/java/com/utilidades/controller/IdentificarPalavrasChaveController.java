package com.utilidades.controller;

import com.utilidades.domain.dto.request.IdentificarPalavrasChaveRequest;
import com.utilidades.domain.dto.response.IdentificarPalavrasChaveResponse;
import com.utilidades.service.IdentificarPalavrasChaveService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class IdentificarPalavrasChaveController {

    private final IdentificarPalavrasChaveService identificarPalavrasChaveService;

    @PostMapping("/identificar-palavras-chave")
    public ResponseEntity<IdentificarPalavrasChaveResponse> identificarPalavrasChave(@RequestBody IdentificarPalavrasChaveRequest mensagem) {

        return ResponseEntity.ok(identificarPalavrasChaveService.identificarPalavrasChave(mensagem));
    }
}
