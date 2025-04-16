package com.pedidos.validation;

import com.pedidos.factory.CompradorFactory;
import com.pedidos.factory.EditableBuyerDataDTOFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompradorValidatorTest {

    @Mock
    private CPFValidator cpfValidator;

    @InjectMocks
    private CompradorValidator compradorValidator;

    @Nested
    class RegistrationValidationScenarios{

        @Test
        @DisplayName("If the data is validated without errors, the buyer will be successfully registered")
        void registrationCompletedSuccessfully() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData(
                    "Ada",
                    "Wong",
                    LocalDate.of(1990, 11, 26),
                    "12345678901");

            //ACT + ASSERT
            Assertions.assertDoesNotThrow(()-> compradorValidator.validateAllDataRegistration(buyer));

            verify(cpfValidator, times(1)).checkCPF(buyer.getCpf());
        }

        @Test
        @DisplayName("Zip code field is empty or null, and should display an error")
        void buyerWithoutZipCode() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertAderessData("", "Praça da Sé", "Sé", "4895", "CS 1", "SP");

            //ACT + ASSERT
            ResponseStatusException exception = Assertions.assertThrows(
                    ResponseStatusException.class, ()-> compradorValidator.validateAllDataRegistration(buyer)
            );

            verify(cpfValidator, times(1)).checkCPF(buyer.getCpf());
            Assertions.assertEquals("O campo CEP é obrigatório e não pode estar vazio!", exception.getReason());
        }

        @Test
        @DisplayName("If the address number field is empty or null, an error should be reported.")
        void BuyerWithoutAddressNumber() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertAderessData("01001-000", "Praça da Sé", "Sé", "", "CS 1", "SP");

            //ACT + ASSERT
            ResponseStatusException exception = Assertions.assertThrows(
                    ResponseStatusException.class, ()-> compradorValidator.validateAllDataRegistration(buyer)
            );

            verify(cpfValidator, times(1)).checkCPF(buyer.getCpf());
            Assertions.assertEquals("O campo NÚMERO é obrigatório e não pode estar vazio!", exception.getReason());
        }

        @Test
        @DisplayName("If the address complement field is empty or null, an error should be reported.")
        void BuyerWithoutAddressComplement() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertAderessData("01001-000", "Praça da Sé", "Sé", "4856", null, "SP");

            //ACT + ASSERT
            ResponseStatusException exception = Assertions.assertThrows(
                    ResponseStatusException.class, ()-> compradorValidator.validateAllDataRegistration(buyer)
            );

            verify(cpfValidator, times(1)).checkCPF(buyer.getCpf());
            Assertions.assertEquals("O campo COMPLEMENTO é obrigatório e não pode estar vazio!", exception.getReason());
        }

        @Test
        @DisplayName("If the name field is empty or null, an error should be reported")
        void buyerWithNoName() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData(
                    "",
                    "Wong",
                    LocalDate.of(1990, 11, 26),
                    "12345678901");

            //ACT + ASSERT
            ResponseStatusException exception = Assertions.assertThrows(
                    ResponseStatusException.class, ()-> compradorValidator.validateAllDataRegistration(buyer)
            );

            verify(cpfValidator,never()).checkCPF(buyer.getCpf());
            Assertions.assertEquals("O campo NOME é obrigatório e não pode estar vazio!", exception.getReason());
        }

        @Test
        @DisplayName("If the last name field is empty or null, an error should be reported")
        void buyerWithNoLastName() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData(
                    "Ada",
                    "",
                    LocalDate.of(1990, 11, 26),
                    "12345678901");

            //ACT + ASSERT
            ResponseStatusException exception = Assertions.assertThrows(
                    ResponseStatusException.class, ()-> compradorValidator.validateAllDataRegistration(buyer)
            );

            verify(cpfValidator, never()).checkCPF(buyer.getCpf());
            Assertions.assertEquals("O campo SOBRENOME é obrigatório e não pode estar vazio!", exception.getReason());
        }

        @Test
        @DisplayName("If the age field is empty or null, an error should be reported")
        void buyerWithNoAge() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData("Ada", "Wong", null, "12345678901");

            //ACT + ASSERT
            ResponseStatusException exception = Assertions.assertThrows(
                    ResponseStatusException.class, ()-> compradorValidator.validateAllDataRegistration(buyer)
            );

            verify(cpfValidator, never()).checkCPF(buyer.getCpf());
            Assertions.assertEquals("O campo data de nascimento é de preenchimento obrigatório e não pode estar vazio!", exception.getReason());
        }

        @Test
        @DisplayName("If the age is less than 18, an error should be displayed")
        void underageBuyer() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData(
                    "Ada",
                    "Wong",
                    LocalDate.of(2010, 11, 26),
                    "12345678901");

            //ACT + ASSERT
            ResponseStatusException exception = Assertions.assertThrows(
                    ResponseStatusException.class, ()-> compradorValidator.validateAllDataRegistration(buyer)
            );

            verify(cpfValidator, never()).checkCPF(buyer.getCpf());
            Assertions.assertEquals("É necessário ter no mínimo 18 anos para se cadastrar na plataforma!", exception.getReason());
        }
    }

    @Nested
    class EditBuyerRegistration{

        @Test
        @DisplayName("If the buyer's address editing data is passed correctly, the request will be successful.")
        void successfulDataEditing(){
            //ARRANGE
            var buyerDataEditableDTO = EditableBuyerDataDTOFactory.completeEditionData(
                    "12345678901",
                    1
            );

            //ACT + ASSERT
            Assertions.assertDoesNotThrow(()-> compradorValidator.editBuyerRegistration(buyerDataEditableDTO));
        }

    }

}
