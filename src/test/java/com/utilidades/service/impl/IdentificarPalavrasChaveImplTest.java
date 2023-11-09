package com.utilidades.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.utilidades.domain.dto.request.IdentificarPalavrasChaveRequest;
import com.utilidades.domain.dto.response.IdentificarPalavrasChaveResponse;
import com.utilidades.properties.IdentificarPalavrasChaveProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {IdentificarPalavrasChaveImpl.class})
@ExtendWith(SpringExtension.class)
class IdentificarPalavrasChaveImplTest {

    @Autowired
    private IdentificarPalavrasChaveImpl identificarPalavrasChaveImpl;

    @MockBean
    private IdentificarPalavrasChaveProperties identificarPalavrasChaveProperties;

    /**
     * Method under test: {@link IdentificarPalavrasChaveImpl#identificarPalavrasChave(IdentificarPalavrasChaveRequest)}
     */
    @Test
    void testIdentificarPalavrasChave() {
        when(identificarPalavrasChaveProperties.getPalavrasChave()).thenReturn("Palavras Chave");
        IdentificarPalavrasChaveResponse actualIdentificarPalavrasChaveResult = identificarPalavrasChaveImpl
                .identificarPalavrasChave(new IdentificarPalavrasChaveRequest("Palavras Chave"));
        verify(identificarPalavrasChaveProperties).getPalavrasChave();
        assertEquals("Palavras Chave", actualIdentificarPalavrasChaveResult.getMensagemOriginal());
        assertEquals("Sequência encontrada: Palavras Chave", actualIdentificarPalavrasChaveResult.getResposta());
    }

    /**
     * Method under test: {@link IdentificarPalavrasChaveImpl#identificarPalavrasChave(IdentificarPalavrasChaveRequest)}
     */
    @Test
    void testIdentificarPalavrasChave2() {
        when(identificarPalavrasChaveProperties.getPalavrasChave()).thenReturn("foo");
        IdentificarPalavrasChaveResponse actualIdentificarPalavrasChaveResult = identificarPalavrasChaveImpl
                .identificarPalavrasChave(new IdentificarPalavrasChaveRequest("Palavras Chave"));
        verify(identificarPalavrasChaveProperties).getPalavrasChave();
        assertEquals("Não foi encontrado uma sequencia válida, tente novamente.",
                actualIdentificarPalavrasChaveResult.getResposta());
        assertEquals("Palavras Chave", actualIdentificarPalavrasChaveResult.getMensagemOriginal());
    }
}
