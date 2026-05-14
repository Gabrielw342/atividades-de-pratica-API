package org.serratec.atividade5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("VIP")
public class ClienteVIP extends Cliente {

    private String consultorResponsavel;

    public String getConsultorResponsavel() {
        return consultorResponsavel;
    }

    public void setConsultorResponsavel(String consultorResponsavel) {
        this.consultorResponsavel = consultorResponsavel;
    }
}