package com.pedidos.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EditableBuyerDataDTO {
    @NotNull
    private Integer id;

    @NotBlank
    private String cpf;

    private BuyerAddressDataDTO buyerAddressDataDTO;

}
