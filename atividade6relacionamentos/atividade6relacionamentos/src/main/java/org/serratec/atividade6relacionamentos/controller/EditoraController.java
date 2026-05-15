package org.serratec.atividade6relacionamentos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.serratec.atividade6relacionamentos.entity.Editora;
import org.serratec.atividade6relacionamentos.repository.EditoraRepository;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    private final EditoraRepository repository;

    public EditoraController(EditoraRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Editora> criar(@RequestBody @Valid Editora editora) {
        Editora salva = repository.save(editora);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public List<Editora> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Editora buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
}