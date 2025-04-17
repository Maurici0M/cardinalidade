package com.pedidos.factory;

import com.pedidos.dto.BuyerAddressDataDTO;

public class BuyerAddressDataDTOFactory {

    public static BuyerAddressDataDTO fullDTOAddress(){
        var endereco = EnderecoFactory.enderecoCompleto();

        return new BuyerAddressDataDTO(
                endereco
        );
    }

    public static BuyerAddressDataDTO insertAddressData(String cep, String logradouro, String bairro, String numero, String complemento, String uf){
        var endereco = EnderecoFactory.enderecoInserirDados(cep, logradouro, bairro, numero, complemento, uf);

        return new BuyerAddressDataDTO(
                endereco
        );
    }

}
