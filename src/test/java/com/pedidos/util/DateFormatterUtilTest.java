package com.pedidos.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DateFormatterUtilTest {

    @Nested
    class FormatDataDDMMYYYY{
        @Test
        @DisplayName("if the date is not null, it should be formatted successfully")
        void DateNotNullAndSuccessfullyFormatted() {
            //ARRANGE
            LocalDate localDate = LocalDate.of(2025, 4, 13);

            //ACT + ASSERT
            Assertions.assertEquals("13/04/2025", DateFormatterUtil.formatDataDDMMYYYY(localDate));
        }

        @Test
        @DisplayName("if the date is null, it should return null")
        void NullDateShouldReturnNull() {
            //ARRANGE
            LocalDate localDate = null;

            //ACT + ASSERT
            Assertions.assertNull(DateFormatterUtil.formatDataDDMMYYYY(localDate));
        }

    }

    @Nested
    class FormatDataYYYYMMDD{
        @Test
        @DisplayName("if the date is not null, it should be formatted successfully")
        void DateNotNullAndSuccessfullyFormatted() {
            //ARRANGE
            LocalDate localDate = LocalDate.of(2025, 4, 13);

            //ACT + ASSERT
            Assertions.assertEquals("2025/04/13", DateFormatterUtil.formatDataYYYYMMDD(localDate));
        }

        @Test
        @DisplayName("if the date is null, it should return null")
        void NullDateShouldReturnNull() {
            //ARRANGE
            LocalDate localDate = null;

            //ACT + ASSERT
            Assertions.assertNull(DateFormatterUtil.formatDataYYYYMMDD(localDate));
        }

    }

}