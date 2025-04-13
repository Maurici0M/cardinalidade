package com.pedidos.util;

import java.util.Objects;

public class TextFormatterUtil {

    public static String captalizeFirstLetter(String text){
        //faz com que a primeira letra sempre seja maiúscula, ex: nome sobrenome -> Nome Sobrenome

        if (Objects.nonNull(text) && text.trim().length() >= 3) {

            String[] words = text.split("\\s+"); // Divide pelo espaço
            StringBuilder capitalizedText = new StringBuilder();

            for (String word : words) {

                if (!word.isEmpty()) {
                    capitalizedText.append(word.substring(0, 1).toUpperCase())
                            .append(word.substring(1).toLowerCase())
                            .append(" ");
                }
            }

            return capitalizedText.toString().trim(); // Remove o espaço extra no final
        }

        return null;
    }

}
