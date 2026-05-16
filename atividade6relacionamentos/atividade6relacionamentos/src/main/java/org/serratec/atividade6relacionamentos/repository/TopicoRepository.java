package org.serratec.atividade6relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.serratec.atividade6relacionamentos.entity.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}