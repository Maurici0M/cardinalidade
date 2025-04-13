package com.pedidos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pedidos.domain.Comprador;
import com.pedidos.util.TextFormatterUtil;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BuyerDataDTO {
    private String nome;
    private String sobrenome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private String cpf;

    private BuyerAddressDataDTO endereco;

    public BuyerDataDTO() {
    }

    public BuyerDataDTO(Comprador comprador) {
        this.nome = TextFormatterUtil.captalizeFirstLetter(comprador.getNome());
        this.sobrenome = TextFormatterUtil.captalizeFirstLetter(comprador.getSobrenome());
        this.dataNascimento = comprador.getDataNascimento();
        this.cpf = comprador.getCpf();
        this.endereco = new BuyerAddressDataDTO(comprador.getEndereco());
    }

}
