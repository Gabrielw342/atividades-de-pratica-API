package org.serratec.atividade5.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.atividade5.exception.EnumValidationException;

import java.util.Arrays;

public enum TipoCliente {

    COMUM,
    VIP,
    PREMIUM;

    @JsonCreator
    public static TipoCliente from(String value) throws EnumValidationException {

        if (value == null) {
            throw new EnumValidationException(
                "TipoCliente obrigatório. Valores aceitos: COMUM, VIP, PREMIUM"
            );
        }

        return Arrays.stream(values())
                .filter(t -> t.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new EnumValidationException(
                                "Tipo inválido. Valores aceitos: COMUM, VIP, PREMIUM"
                        )
                );
    }
}