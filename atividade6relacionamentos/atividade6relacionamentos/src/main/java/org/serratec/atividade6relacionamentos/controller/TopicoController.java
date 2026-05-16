package org.serratec.atividade6relacionamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.serratec.atividade6relacionamentos.entity.Topico;
import org.serratec.atividade6relacionamentos.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public Topico salvar(@Valid @RequestBody Topico topico) {
        return repository.save(topico);
    }

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }
}