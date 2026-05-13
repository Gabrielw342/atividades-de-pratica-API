package org.serratectrabalho.atividadee.atividade4base.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {

    private int status;
    private String titulo;
    private LocalDateTime dataHora;
    private List<String> erros;

    public ErroResposta(int status, String titulo, List<String> erros) {
        this.status = status;
        this.titulo = titulo;
        this.dataHora = LocalDateTime.now();
        this.erros = erros;
    }

    public int getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public List<String> getErros() {
        return erros;
    }
}