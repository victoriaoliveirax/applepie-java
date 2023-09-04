package com.teste.rotinacredito.repository;

import com.teste.rotinacredito.dto.ContaDTO;
import com.teste.rotinacredito.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
