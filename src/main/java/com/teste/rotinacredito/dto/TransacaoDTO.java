package com.teste.rotinacredito.dto;

import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.TipoOperacao;

import java.util.Date;

public class TransacaoDTO {

    public Long contaId;
    public TipoOperacao tipoOperacao;
    public Date dataTransacao;
    
}