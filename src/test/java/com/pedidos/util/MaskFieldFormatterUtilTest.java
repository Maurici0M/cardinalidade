package com.pedidos.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MaskFieldFormatterUtilTest {

    @Nested
    class CPFMask{
        @Test
        @DisplayName("Must return CPF in ***.***.**0-00")
        void mustFormatCPFFieldSuccessfully() {
            //ARRANGE
            var cpf = "12345678901";

            //ACT + ASSERT
            Assertions.assertEquals("***.***.**9-01", MaskFieldFormatterUtil.cpfMask(cpf));
        }

    }

}