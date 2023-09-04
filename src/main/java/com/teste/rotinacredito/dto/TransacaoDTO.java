package com.teste.rotinacredito.dto;

import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.TipoOperacao;

import java.util.Date;
import java.util.UUID;

public class TransacaoDTO {

    public Long contaId;
    public TipoOperacao tipoOperacao;

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double valor;

}