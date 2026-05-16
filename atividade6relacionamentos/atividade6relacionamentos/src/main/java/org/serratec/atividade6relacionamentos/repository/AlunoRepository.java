package org.serratec.atividade6relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.serratec.atividade6relacionamentos.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}