package org.serratec.atividade6relacionamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.serratec.atividade6relacionamentos.entity.Curso;
import org.serratec.atividade6relacionamentos.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    public Curso salvar(@Valid @RequestBody Curso curso) {
        return repository.save(curso);
    }

    @GetMapping
    public List<Curso> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Curso buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}