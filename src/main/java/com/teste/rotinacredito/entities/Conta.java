package com.teste.rotinacredito.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.List;
import java.util.Date;

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

    public Conta(Double limite, Pessoa pessoa) {
        this.limite = limite;
        this.pessoa = pessoa;
    }

    @NotNull(message = "Limite em conta não pode ser nulo")
    public Double limite;

    @NotNull(message = "Pessoa não pode ser nulo")
    @ManyToOne
    public Pessoa pessoa;
    @NotNull (message = "Data de alteração de limite")
    @UpdateTimestamp
    public Date dataLimite;
    public Conta(Long id, Integer conta){
        this.id = id;
        this.conta = conta;
    }

    public Conta(Long id) {
        this.id = id;
    }
    public Conta() {
    }

    public Conta(Long id, Double limite) {
        this.id = id;
        this.limite = limite;
    }

    public Conta (Double limite) {
        this.limite = limite;
    }

    public Conta(Long id, Integer conta, Double limite, Date dataLimite) {
        this.id = id;
        this.conta = conta;
        this.limite = limite;
        this.dataLimite = dataLimite;
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

}
