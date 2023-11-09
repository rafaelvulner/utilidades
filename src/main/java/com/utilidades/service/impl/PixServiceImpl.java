package com.utilidades.service.impl;

import com.utilidades.domain.Pix;
import com.utilidades.service.PixService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PixServiceImpl implements PixService {

    public Pix extrairIdentificadorPIX(String input) {
        Pix pix = new Pix();
        // Expressão regular para encontrar um identificador PIX (telefone, email, CPF, CNPJ ou chave aleatória)
        Pattern pattern = Pattern.compile("(?<=: ).*");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Retorna o identificador PIX encontrado na string
            pix.setIdentificadorPix(matcher.group());
        } else {
            // Caso nenhum identificador PIX seja encontrado
            pix.setErro("Identificador PIX não encontrado na string.");
        }
        return pix;
    }
}
