package org.serratec.atividade6relacionamentos.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.serratec.atividade6relacionamentos.entity.Editora;
import org.serratec.atividade6relacionamentos.entity.Livro;
import org.serratec.atividade6relacionamentos.repository.EditoraRepository;
import org.serratec.atividade6relacionamentos.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;
    private final EditoraRepository editoraRepository;

    public LivroController(LivroRepository repository, EditoraRepository editoraRepository) {
        this.repository = repository;
        this.editoraRepository = editoraRepository;
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@Valid @RequestBody Livro livro) {

        Long idEditora = livro.getEditora().getId();

        Editora editora = editoraRepository.findById(idEditora)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada"));

        livro.setEditora(editora);

        Livro salvo = repository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Livro> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
}