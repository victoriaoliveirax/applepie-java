package com.teste.rotinacredito.controller;

import com.teste.rotinacredito.dto.ContaDTO;
import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/controle-conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/conta")
    public Conta cadastrarConta(
            @RequestBody ContaDTO contaDTO
    ) {
        return contaService.cadastrarConta(contaDTO);
    }

    @GetMapping("/conta/{id}")
    public Conta cadastrarConta(
            @PathVariable("id") Long id
    ) throws Exception {
        return contaService.regatarConta(id);
    }

}
