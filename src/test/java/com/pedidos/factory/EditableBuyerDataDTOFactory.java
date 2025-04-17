package com.pedidos.factory;

import com.pedidos.dto.BuyerEditableDataDTO;

public class EditableBuyerDataDTOFactory {

    public static BuyerEditableDataDTO completeEditionData(String cpf, Integer id){
        var buyerAddressData = BuyerAddressDataDTOFactory.fullDTOAddress();

        return new BuyerEditableDataDTO(cpf, buyerAddressData, id);
    }

    public static BuyerEditableDataDTO insertAddressData(String cep, String logradouro, String bairro, String numero, String complemento, String uf){
        var buyerAddressData = BuyerAddressDataDTOFactory.insertAddressData(cep, logradouro, bairro, numero, complemento, uf);

        return new BuyerEditableDataDTO("12345678901", buyerAddressData, 1);
    }

}
