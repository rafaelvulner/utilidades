package com.utilidades.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IdentificarPalavrasChaveProperties {

    @Value("${regex}")
    private String palavrasChave;
}
