package com.teste.rotinacredito.repository;

import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);
}
