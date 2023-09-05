package com.teste.rotinacredito.services;

import com.teste.rotinacredito.dto.ContaDTO;
import com.teste.rotinacredito.dto.TransacaoDTO;
import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.TipoOperacao;
import com.teste.rotinacredito.entities.Transacao;
import com.teste.rotinacredito.repository.ContaRepository;
import com.teste.rotinacredito.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository;

    public Transacao realizarTransacao(TransacaoDTO transacaoDTO) throws Exception {

        transacaoDTO.setValor(setValueForTransactionType(transacaoDTO.valor, transacaoDTO.tipoOperacao));
        Optional<Conta> conta = contaRepository.findById(transacaoDTO.contaId);
        if (conta.get().limite + transacaoDTO.valor >= 0) {
            contaRepository.save(new Conta(transacaoDTO.contaId,conta.get().limite + transacaoDTO.valor));
            return transacaoRepository.save(
                    new Transacao(
                            new Conta(transacaoDTO.contaId),
                            transacaoDTO.tipoOperacao,
                            Date.from(Instant.now()),
                            transacaoDTO.getValor()
                    )
            );
        }
throw new Exception("Você não possui saldo.");
    }

    private Double setValueForTransactionType(Double value, TipoOperacao tipoOperacao) {
        return switch (tipoOperacao) {
            case COMPRA_A_VISTA, COMPRA_PARCELADA, SAQUE -> -Math.abs(value);
            default -> Math.abs(value);
        };
    }

    public List<Transacao> resgatarTransacoesPorConta(Long idConta) {
        return transacaoRepository.findAllByContaId(idConta);

    }
}
