package com.teste.rotinacredito.repository;

import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    @Query("SELECT t FROM Transacao t WHERE t.conta.id = :contaId ")
    List<Transacao> findAllByContaId(Long contaId);
}
