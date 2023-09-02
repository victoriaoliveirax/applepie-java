package com.teste.rotinacredito.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @ManyToOne
    public Conta conta;
    @Enumerated(EnumType.STRING)
    public TipoOperacao tipoOperacao;

    public Date dataTransacao;

    public Transacao(Long id, Conta conta, TipoOperacao tipoOperacao, Date dataTransacao) {
        this.id = id;
        this.conta = conta;
        this.tipoOperacao = tipoOperacao;
        this.dataTransacao = dataTransacao;
    }

    public Transacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Transacao(Conta conta, TipoOperacao tipoOperacao, Date dataTransacao) {
        this.conta = conta;
        this.tipoOperacao = tipoOperacao;
        this.dataTransacao = dataTransacao;
    }



}