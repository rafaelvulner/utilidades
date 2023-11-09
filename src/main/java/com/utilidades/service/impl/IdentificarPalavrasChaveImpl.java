package com.utilidades.service.impl;

import com.utilidades.domain.dto.request.IdentificarPalavrasChaveRequest;
import com.utilidades.domain.dto.response.IdentificarPalavrasChaveResponse;
import com.utilidades.properties.IdentificarPalavrasChaveProperties;
import com.utilidades.service.IdentificarPalavrasChaveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class IdentificarPalavrasChaveImpl implements IdentificarPalavrasChaveService {


    private IdentificarPalavrasChaveProperties palavrasChaveProperties;
    @Override
    public IdentificarPalavrasChaveResponse identificarPalavrasChave(IdentificarPalavrasChaveRequest mensagem) {

        String regex = palavrasChaveProperties.getPalavrasChave();

        // Construindo o padrão
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        // Encontrando as sequências na mensagem
        Matcher matcher = pattern.matcher(mensagem.getPalavrasChave());


        // Identificando as sequências encontradas
        if (matcher.find()) {
            return new IdentificarPalavrasChaveResponse("Sequência encontrada: "+matcher.group(), mensagem.getPalavrasChave() );
        }

        return new IdentificarPalavrasChaveResponse("Não foi encontrado uma sequencia válida, tente novamente.", mensagem.getPalavrasChave());
    }
}
