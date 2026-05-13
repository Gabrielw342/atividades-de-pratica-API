package org.serratectrabalho.atividadee.atividade4base.controller;

import org.serratectrabalho.atividadee.atividade4base.model.Funcionario;
import org.serratectrabalho.atividadee.atividade4base.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public List<Funcionario> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        Funcionario salvo = repository.save(funcionario);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(
            @RequestBody Funcionario funcionario,
            @PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        funcionario.setId(id);

        Funcionario atualizado = repository.save(funcionario);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public List<Funcionario> buscarPorNome(@RequestParam String nome) {
        return repository.findAll()
                .stream()
                .filter(f -> f.getNome()
                        .toLowerCase()
                        .contains(nome.toLowerCase()))
                .toList();
    }
}