package org.serratec.atividade6relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.serratec.atividade6relacionamentos.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}