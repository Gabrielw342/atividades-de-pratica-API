package org.serratec.atividade6relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.serratec.atividade6relacionamentos.entity.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}