package org.serratec.atividade6relacionamentos.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.serratec.atividade6relacionamentos.entity.Curso;
import org.serratec.atividade6relacionamentos.entity.Aluno;
import org.serratec.atividade6relacionamentos.repository.CursoRepository;
import org.serratec.atividade6relacionamentos.repository.AlunoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoRepository repository;
    private final AlunoRepository alunoRepository;

    public CursoController(CursoRepository repository, AlunoRepository alunoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
    }

    @PostMapping
    public ResponseEntity<Curso> criar(@Valid @RequestBody Curso curso) {

        if (curso.getAlunos() != null && !curso.getAlunos().isEmpty()) {
            List<Aluno> alunosBanco = curso.getAlunos().stream()
                .map(a -> alunoRepository.findById(a.getId())
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado")))
                .toList();

            curso.setAlunos(alunosBanco);
        }

        Curso salvo = repository.save(curso);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @Query("SELECT c FROM Curso c LEFT JOIN FETCH c.topicos WHERE c.id = :id")
    Curso buscarPorIdComTopicos(@Param("id") Long id) {
		return null;
	}

    @GetMapping("/{id}")
    public Curso buscar(@PathVariable Long id) {
        return repository.findByIdComTopicos(id)
                .orElseThrow();
    }
}