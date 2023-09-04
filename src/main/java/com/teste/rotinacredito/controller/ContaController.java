package com.teste.rotinacredito.controller;

import com.teste.rotinacredito.dto.ContaDTO;
import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.services.ContaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Controle de conta", description = "API dedicada ao controle de conta")
@RestController
@RequestMapping(value = "/controle-conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/conta")
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrarConta(
            @RequestBody ContaDTO contaDTO
    ) throws Exception {
        return contaService.cadastrarConta(contaDTO);
    }

    @GetMapping("/conta/{id}")
    public Conta resgatarConta(
            @PathVariable("id") Long id
    ) throws Exception {
        return contaService.resgatarConta(id);
    }

}
