package org.serratectrabalho.atividadee.atividade4base.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> handleValidation(MethodArgumentNotValidException ex) {

        List<String> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .toList();

        ErroResposta resposta = new ErroResposta(
                400,
                "Erro de validação",
                erros
        );

        return ResponseEntity.badRequest().body(resposta);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResposta> handleNaoEncontrado(RecursoNaoEncontradoException ex) {

        return ResponseEntity.status(404).body(
                new ErroResposta(404, ex.getMessage(), List.of())
        );
    }
}