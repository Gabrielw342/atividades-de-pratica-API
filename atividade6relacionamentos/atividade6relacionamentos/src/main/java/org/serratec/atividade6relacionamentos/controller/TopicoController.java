package org.serratec.atividade6relacionamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.serratec.atividade6relacionamentos.entity.*;
import org.serratec.atividade6relacionamentos.repository.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Topico salvar(@RequestBody Topico topico) {

        Curso curso = cursoRepository.findById(topico.getCurso().getId())
                .orElseThrow();

        topico.setCurso(curso);

        return topicoRepository.save(topico);
    }

    @GetMapping
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }
}