package com.utilidades.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificarPalavrasChaveResponse {

    private String resposta;
    private String mensagemOriginal;
}
