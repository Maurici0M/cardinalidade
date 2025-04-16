package com.pedidos.factory;

import com.pedidos.dto.EditableBuyerDataDTO;

public class EditableBuyerDataDTOFactory {

    public static EditableBuyerDataDTO completeEditionData(String cpf, Integer id){
        var buyerAddressData = BuyerAddressDataDTOFactory.FullDTOAddress();

        return new EditableBuyerDataDTO(cpf, buyerAddressData, id);
    }

}
