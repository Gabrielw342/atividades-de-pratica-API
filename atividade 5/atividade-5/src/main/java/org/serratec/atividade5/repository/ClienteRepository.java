package org.serratec.atividade5.repository;

import org.serratec.atividade5.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}