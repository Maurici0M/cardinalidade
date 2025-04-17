package com.pedidos.util;

import com.pedidos.domain.Cidade;
import com.pedidos.domain.Endereco;
import com.pedidos.dto.BuyerEditableDataDTO;

public class ToEnderecoFormatterUtil {

    public static Endereco formatBuyerEditableDataDTOtoAddress(BuyerEditableDataDTO buyerEditableDataDTO){

        //Recebe um tipo BuyerEditableDataDTO e converte para um tipo Endereço, usando um construtor de Endereço

        return new Endereco(
                buyerEditableDataDTO.getEndereco().getCep(),
                buyerEditableDataDTO.getEndereco().getLogradouro(),
                buyerEditableDataDTO.getEndereco().getBairro(),
                buyerEditableDataDTO.getEndereco().getNumero(),
                buyerEditableDataDTO.getEndereco().getComplemento(),
                new Cidade(buyerEditableDataDTO),
                buyerEditableDataDTO.getEndereco().getUf()
        );

    }

}
