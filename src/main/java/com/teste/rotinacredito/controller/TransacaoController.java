package com.teste.rotinacredito.controller;

import com.teste.rotinacredito.dto.TransacaoDTO;
import com.teste.rotinacredito.entities.Transacao;
import com.teste.rotinacredito.services.ContaService;
import com.teste.rotinacredito.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/controle-transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacao")
    public Transacao realizarTransacao(
            @RequestBody TransacaoDTO transacaoDTO
    ) {
        return transacaoService.realizarTransacao(transacaoDTO);
    }
}
