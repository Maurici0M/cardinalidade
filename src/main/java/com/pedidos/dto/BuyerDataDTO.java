package com.pedidos.dto;

import com.pedidos.domain.Comprador;
import com.pedidos.util.DateFormatterUtil;
import com.pedidos.util.MaskFieldFormatterUtil;
import com.pedidos.util.TextFormatterUtil;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BuyerDataDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String cpf;

    private BuyerAddressDataDTO endereco;

    public BuyerDataDTO() {
    }

    public BuyerDataDTO(Comprador comprador) {
        this.id = comprador.getId();
        this.nome = TextFormatterUtil.captalizeFirstLetter(comprador.getNome());
        this.sobrenome = TextFormatterUtil.captalizeFirstLetter(comprador.getSobrenome());
        this.dataNascimento = comprador.getDataNascimento();
        this.cpf = MaskFieldFormatterUtil.cpfMask(comprador.getCpf());
        this.endereco = new BuyerAddressDataDTO(comprador.getEndereco());
    }

}
