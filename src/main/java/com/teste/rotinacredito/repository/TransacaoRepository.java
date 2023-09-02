package com.teste.rotinacredito.repository;

import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
