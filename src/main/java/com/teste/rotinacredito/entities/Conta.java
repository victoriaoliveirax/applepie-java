package com.teste.rotinacredito.entities;

import jakarta.persistence.*;

@Entity
@Table(name="conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public Integer conta;
    public String nome;
    public String cpf;

    public Conta(Integer conta, String nome, String cpf) {
        this.conta = conta;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Conta(Long id, Integer conta, String nome, String cpf) {
        this.id = id;
        this.conta = conta;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Conta(Long id) {
        this.id = id;
    }
    public Conta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
