package com.utilidades.service;

import com.utilidades.domain.dto.request.IdentificarPalavrasChaveRequest;
import com.utilidades.domain.dto.response.IdentificarPalavrasChaveResponse;

public interface IdentificarPalavrasChaveService {

    IdentificarPalavrasChaveResponse identificarPalavrasChave(IdentificarPalavrasChaveRequest mensagem);
}
