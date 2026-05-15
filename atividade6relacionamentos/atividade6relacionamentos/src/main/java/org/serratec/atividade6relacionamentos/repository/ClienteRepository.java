package org.serratec.atividade6relacionamentos.repository;

import org.serratec.atividade6relacionamentos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}