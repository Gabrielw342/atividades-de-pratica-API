package org.serratec.atividade6relacionamentos.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.serratec.atividade6relacionamentos.entity.Avaliacao;
import org.serratec.atividade6relacionamentos.entity.Livro;
import org.serratec.atividade6relacionamentos.repository.AvaliacaoRepository;
import org.serratec.atividade6relacionamentos.repository.LivroRepository;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoRepository repository;
    private final LivroRepository livroRepository;

    public AvaliacaoController(AvaliacaoRepository repository, LivroRepository livroRepository) {
        this.repository = repository;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<Avaliacao> criar(@Valid @RequestBody Avaliacao avaliacao) {

        Long idLivro = avaliacao.getLivro().getId();

        Livro livro = livroRepository.findById(idLivro)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        avaliacao.setLivro(livro);

        Avaliacao salva = repository.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public List<Avaliacao> listar() {
        return repository.findAll();
    }
}