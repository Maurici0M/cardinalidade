package com.pedidos.dto;

import com.pedidos.domain.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerAddressDataDTO {
    private String cep;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String uf;

    public BuyerAddressDataDTO() {
    }

    public BuyerAddressDataDTO(Endereco endereco) {
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.bairro = endereco.getBairro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.cidade = endereco.getCidade().getNome();
        this.estado = endereco.getCidade().getEstado().getNome();
        this.uf = endereco.getUf().toUpperCase();
    }

}
