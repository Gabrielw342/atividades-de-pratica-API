package org.serratec.atividade6relacionamentos.repository;

import org.serratec.atividade6relacionamentos.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}