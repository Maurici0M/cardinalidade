package com.pedidos.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextFormatterUtilTest {

    @Test
    @DisplayName("If the text to be converted is not empty, null and has 3 characters or more, it should convert successfully.")
    void capitalizeTheFirstLetterSuccess() {
        //ARRANGE
        String text = "aDa wONg";

        //ACT + ASSERT
        Assertions.assertEquals("Ada Wong", TextFormatterUtil.captalizeFirstLetter(text));
    }

    @Test
    @DisplayName("If the text to be converted is null, it should return null")
    void capitalizeFirstLetterErrorTextNull() {
        //ARRANGE
        String text = null;

        //ACT + ASSERT
        Assertions.assertNull(TextFormatterUtil.captalizeFirstLetter(text));
    }

    @Test
    @DisplayName("If the text to be converted is empty, it should return null")
    void capitalizeFirstLetterErrorTextEmpty() {
        //ARRANGE
        String text = "         "; //string vazia, mas, com espaços (o trim deve ignorar os espaços e enviar retorno null)

        //ACT + ASSERT
        Assertions.assertNull(TextFormatterUtil.captalizeFirstLetter(text));
    }

    @Test
    @DisplayName("If the text to be converted has less than 3 letters, it should return null")
    void capitalizeFirstLetterErrorLessThanThreeLetters() {
        //ARRANGE
        String text = "Ad";

        //ACT + ASSERT
        Assertions.assertNull(TextFormatterUtil.captalizeFirstLetter(text));
    }

}
