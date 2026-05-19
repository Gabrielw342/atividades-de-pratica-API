package org.serratec.atividade6relacionamentos.controller;

import java.util.List;

import org.serratec.atividade6relacionamentos.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.serratec.atividade6relacionamentos.entity.Curso;
import org.serratec.atividade6relacionamentos.entity.Topico;
import org.serratec.atividade6relacionamentos.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;
    
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso salvar(@Valid @RequestBody Curso curso) {
        return repository.save(curso);
    }

    @GetMapping
    public List<Curso> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/topicos")
    public List<Topico> listarTopicos(@PathVariable Long id) {
        return topicoRepository.findByCursoId(id);
    
    }
}