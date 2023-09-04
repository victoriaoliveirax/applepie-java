package com.teste.rotinacredito.controller;

import com.teste.rotinacredito.dto.TransacaoDTO;
import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.Transacao;
import com.teste.rotinacredito.services.ContaService;
import com.teste.rotinacredito.services.TransacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/controle-transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacao")
    @ResponseStatus(HttpStatus.CREATED)
    public Transacao realizarTransacao(
            @RequestBody TransacaoDTO transacaoDTO
    ) throws Exception {
        return transacaoService.realizarTransacao(transacaoDTO);
    }
    @GetMapping("/conta/{idConta}")
    public List<Transacao> regastarTransacoes(
            @PathVariable("idConta") Long idConta
    ) throws Exception {
        return transacaoService.resgatarTransacoesPorConta(idConta);
    }
}
