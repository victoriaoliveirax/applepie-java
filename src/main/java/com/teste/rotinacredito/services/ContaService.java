package com.teste.rotinacredito.services;

import com.teste.rotinacredito.dto.ContaDTO;
import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.repository.ContaRepository;
import com.teste.rotinacredito.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.teste.rotinacredito.utils.Utils.isCPF;
import static com.teste.rotinacredito.utils.Utils.removeSpecialCharacters;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta cadastrarConta(
            ContaDTO contaDTO
    ) throws Exception {

        contaDTO.setCpf(
                removeSpecialCharacters(contaDTO.cpf)
        );

        isCPF(contaDTO.getCpf());
        return contaRepository.save(new Conta(
                contaDTO.getNome(), contaDTO.getCpf(),contaDTO.getSaldo()
        ));
    }


    public Conta resgatarConta(Long id) throws Exception {
        return contaRepository.findById(id).orElseThrow(() -> new Exception("Conta não encontrada."));
    }

}
