package com.pedidos.validation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Component
public class CPFValidator {

    public void checkCPF(String cpf){
        if (Objects.isNull(cpf) || cpf.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O campo CPF é obrigatório e não pode estar vazio!");
        }

        else if (cpf.trim().length() != 11) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O campo CPF precisa ter 11 números!");
        }
    }

}
