package com.pedidos.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateFormatterUtil {

    public static String formatDataDDMMYYYY(LocalDate date){
        //formata a data no padrão brasileiro 13/04/2025
        if (Objects.nonNull(date)){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            return date.format(dateTimeFormatter);
        }

        return null;
    }

    public static String formatDataYYYYMMDD(LocalDate date){
        //formata a data no padrão 2025/04/13
        if (Objects.nonNull(date)){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            return date.format(dateTimeFormatter);
        }

        return null;
    }

}
