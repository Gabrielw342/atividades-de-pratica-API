package org.serratec.atividade6relacionamentos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.serratec.atividade6relacionamentos.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT c FROM Curso c LEFT JOIN FETCH c.topicos WHERE c.id = :id")
    Optional<Curso> findByIdComTopicos(@Param("id") Long id);
}