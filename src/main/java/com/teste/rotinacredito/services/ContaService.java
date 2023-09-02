package com.teste.rotinacredito.services;

import com.teste.rotinacredito.dto.ContaDTO;
import com.teste.rotinacredito.dto.TransacaoDTO;
import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.Transacao;
import com.teste.rotinacredito.repository.ContaRepository;
import com.teste.rotinacredito.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
   private ContaRepository contaRepository;
    public Conta cadastrarConta(
            ContaDTO contaDTO
    ) {
        return contaRepository.save(new Conta(
            contaDTO.conta, contaDTO.nome, contaDTO.cpf
        ));
    }


    public Conta regatarConta(Long id) throws Exception {
        return contaRepository.findById(id).orElseThrow();
    }

}
