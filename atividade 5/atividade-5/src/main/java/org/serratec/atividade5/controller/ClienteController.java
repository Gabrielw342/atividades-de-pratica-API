package org.serratec.atividade5.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.serratec.atividade5.exception.EnumValidationException;
import org.serratec.atividade5.model.Cliente;
import org.serratec.atividade5.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@Valid @RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }
   

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex) {

        String msg = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .reduce((a, b) -> a + " | " + b)
                .orElse("Erro de validação");

        return ResponseEntity.badRequest().body(msg);
    }

   
    @ExceptionHandler(EnumValidationException.class)
    public ResponseEntity<String> erro(EnumValidationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}