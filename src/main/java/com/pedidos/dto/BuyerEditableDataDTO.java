package com.pedidos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerEditableDataDTO {
    private Integer id;

    private String cpf;

    private BuyerAddressDataDTO endereco;

    public BuyerEditableDataDTO() {
    }

    public BuyerEditableDataDTO(String cpf, BuyerAddressDataDTO endereco, Integer id) {
        this.cpf = cpf;
        this.endereco = endereco;
        this.id = id;
    }

}
