package org.serratectrabalho.atividadee.atividade4base.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoCliente {
    PF,
    PJ;

    @JsonCreator
    public static TipoCliente fromString(String value) {
        for (TipoCliente tipo : TipoCliente.values()) {
            if (tipo.name().equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de cliente inválido");
    }
}