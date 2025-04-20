package com.pedidos.util;

import java.util.Objects;

public class MaskFieldFormatterUtil {

    public static String cpfMask(String cpf){
        //irá formatar a saída do cpf em ***.***.**0-00

        if (Objects.nonNull(cpf) && cpf.trim().length() == 11){

            //charAt capturará o elemento de índice 8 e o substring mostrará todos os elementos a partir do índice 9
            return "***.***.**" + cpf.charAt(8) + "-" + cpf.substring(9);
        }

        return cpf;
    }

}
