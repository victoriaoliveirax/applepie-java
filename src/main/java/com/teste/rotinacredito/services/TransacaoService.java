package com.teste.rotinacredito.services;

import com.teste.rotinacredito.dto.ContaDTO;
import com.teste.rotinacredito.dto.TransacaoDTO;
import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.Transacao;
import com.teste.rotinacredito.repository.ContaRepository;
import com.teste.rotinacredito.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    private TransacaoRepository transacaoRepository;

    public Transacao realizarTransacao(TransacaoDTO transacaoDTO) {
        return transacaoRepository.save(
            new Transacao(
                    new Conta(transacaoDTO.contaId),
                    transacaoDTO.tipoOperacao,
                    transacaoDTO.dataTransacao
            )
        );
    }
}
