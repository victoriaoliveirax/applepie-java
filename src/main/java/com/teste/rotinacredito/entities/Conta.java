package com.teste.rotinacredito.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.util.List;

@Entity
@Table(name="conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique=true, columnDefinition = "serial", updatable = false)
    @Generated(GenerationTime.INSERT)
    @NotNull(message = "Conta não pode ser nulo")
    public Integer conta;
    @NotNull(message = "Saldo em conta")
    public Double saldo;
    @NotNull(message = "Nome não pode ser nulo")
    public String nome;

    @NotNull(message = "CPF não pode ser nulo")
    @Column(unique=true)
    public String cpf;

    public Conta( String nome, String cpf) {
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

    public Conta(Long id, Double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public Conta(String nome, String cpf, Double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
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
