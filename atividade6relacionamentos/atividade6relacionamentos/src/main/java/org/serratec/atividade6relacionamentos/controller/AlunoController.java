package org.serratec.atividade6relacionamentos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.serratec.atividade6relacionamentos.entity.Aluno;
import org.serratec.atividade6relacionamentos.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@Valid @RequestBody Aluno aluno) {
        return repository.save(aluno);
    }

    @GetMapping
    public List<Aluno> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}