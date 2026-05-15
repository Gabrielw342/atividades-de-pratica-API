package org.serratec.atividade6relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.serratec.atividade6relacionamentos.entity.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
}