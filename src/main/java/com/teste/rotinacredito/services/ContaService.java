package com.teste.rotinacredito.services;

import com.teste.rotinacredito.dto.ContaDTO;
import com.teste.rotinacredito.entities.Conta;
import com.teste.rotinacredito.entities.Pessoa;
import com.teste.rotinacredito.repository.ContaRepository;
import com.teste.rotinacredito.repository.PessoaRepository;
import com.teste.rotinacredito.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import static com.teste.rotinacredito.utils.Utils.isCPF;
import static com.teste.rotinacredito.utils.Utils.removeSpecialCharacters;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Conta cadastrarConta(
            ContaDTO contaDTO
    ) throws Exception {
        try {
            contaDTO.setCpf(
                    removeSpecialCharacters(contaDTO.cpf)
            );

            isCPF(contaDTO.getCpf());
            Pessoa pessoaRegistrada = pessoaRepository.findByCpf(contaDTO.getCpf());
            if (pessoaRegistrada == null){
            pessoaRegistrada = pessoaRepository.save(new Pessoa(contaDTO.getNome(), contaDTO.getCpf()));}

            return contaRepository.save(new Conta(
                    contaDTO.getLimite(),
                    pessoaRegistrada
            ));
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }


    public Conta resgatarConta(Long id) throws Exception {
        return contaRepository.findById(id).orElseThrow(() -> new Exception("Conta não encontrada."));
    }

}
