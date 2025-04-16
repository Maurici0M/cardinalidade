package com.pedidos.factory;

import com.pedidos.dto.BuyerAddressDataDTO;

public class BuyerAddressDataDTOFactory {

    public static BuyerAddressDataDTO FullDTOAddress(){
        var endereco = EnderecoFactory.enderecoCompleto();

        return new BuyerAddressDataDTO(
                endereco
        );
    }

}
