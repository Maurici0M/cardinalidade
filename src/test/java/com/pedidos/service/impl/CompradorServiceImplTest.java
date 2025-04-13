package com.pedidos.service.impl;

import com.pedidos.factory.CompradorFactory;
import com.pedidos.repository.CompradorRepository;
import com.pedidos.validation.CPFValidator;
import com.pedidos.validation.CompradorValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompradorServiceImplTest {

    @Mock
    private CompradorRepository compradorRepository;

    @Spy
    private CompradorValidator compradorValidator;

    @Mock
    private CPFValidator cpfValidator;

    @InjectMocks
    private CompradorServiceImpl compradorService;

    @Nested
    class registerBuyer{

        @Test
        @DisplayName("If the buyer's CPF is empty or null, an error should be displayed.")
        void buyerWithoutCPF() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData(
                    "Claire",
                    "Redfield",
                    LocalDate.of(1990, 11, 26),
                    null
            );

            //ASSERT
            Assertions.assertThrows(ResponseStatusException.class, ()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do metodo de validação
            verify(compradorValidator, times(1)).validateAllDataRegistration(buyer);

            //garante que NÃO HOUVE interação do repository com os seguintes metodos
            verify(compradorRepository, never()).findById(buyer.getId());
            verify(compradorRepository, never()).findByCpf(buyer.getCpf());
            verify(compradorRepository, never()).save(buyer);
        }

        @Test
        @DisplayName("If the buyer's NAME is empty or null, an error should be displayed.")
        void buyerWithoutName() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData(
                    "     ",
                    "Redfield",
                    LocalDate.of(1990, 11, 26),
                    "12345678901"
            );

            //ASSERT
            Assertions.assertThrows(ResponseStatusException.class, ()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do metodo de validação
            verify(compradorValidator, times(1)).validateAllDataRegistration(buyer);

            //garante que NÃO HOUVE interação do repository com os seguintes metodos
            verify(compradorRepository, never()).findById(buyer.getId());
            verify(compradorRepository, never()).findByCpf(buyer.getCpf());
            verify(compradorRepository, never()).save(buyer);
        }

        @Test
        @DisplayName("If the buyer's LAST NAME is empty or null, an error should be displayed.")
        void buyerWithoutLastName() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData(
                    "Claire",
                    "    ",
                    LocalDate.of(1990, 11, 26),
                    "12345678901"
            );

            //ASSERT
            Assertions.assertThrows(ResponseStatusException.class, ()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do metodo de validação
            verify(compradorValidator, times(1)).validateAllDataRegistration(buyer);

            //garante que NÃO HOUVE interação do repository com os seguintes metodos
            verify(compradorRepository, never()).findById(buyer.getId());
            verify(compradorRepository, never()).findByCpf(buyer.getCpf());
            verify(compradorRepository, never()).save(buyer);
        }

        @Test
        @DisplayName("If the buyer's AGE is empty or null, an error should be displayed.")
        void buyerWithoutAge() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData(
                    "Claire",
                    "    ",
                    null,
                    "12345678901"
            );

            //ASSERT
            Assertions.assertThrows(ResponseStatusException.class, ()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do metodo de validação
            verify(compradorValidator, times(1)).validateAllDataRegistration(buyer);

            //garante que NÃO HOUVE interação do repository com os seguintes metodos
            verify(compradorRepository, never()).findById(buyer.getId());
            verify(compradorRepository, never()).findByCpf(buyer.getCpf());
            verify(compradorRepository, never()).save(buyer);
        }

        @Test
        @DisplayName("If the buyer is a minor, he/she must report the error.")
        void underageBuyer() {
            //ARRANGE
            var buyer = CompradorFactory.buyerInsertPersonalData(
                    "Claire",
                    "Redfield",
                    LocalDate.of(2010, 11, 26),
                    "12345678901"
            );

            //ASSERT
            Assertions.assertThrows(ResponseStatusException.class, ()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do metodo de validação
            verify(compradorValidator, times(1)).validateAllDataRegistration(buyer);

            //garante que NÃO HOUVE interação do repository com os seguintes metodos
            verify(compradorRepository, never()).findById(buyer.getId());
            verify(compradorRepository, never()).findByCpf(buyer.getCpf());
            verify(compradorRepository, never()).save(buyer);
        }

        @Test
        @DisplayName("If the ID search returns a buyer, it should report an error")
        void buyerWithRegisteredID() {
            //ARRANGE
            var buyer = CompradorFactory.buyerWithCompleteData();

            //ACT
            BDDMockito.given(compradorRepository.findById(buyer.getId())).willReturn(Optional.of(buyer));

            //ASSERT
            Assertions.assertThrows(ResponseStatusException.class, ()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do repository com o metodo findById
            verify(compradorRepository, times(1)).findById(buyer.getId());

            //garante que NÃO HOUVE interação do repository com os seguintes metodos
            verify(compradorRepository, never()).findByCpf(buyer.getCpf());
            verify(compradorRepository, never()).save(buyer);
        }

        @Test
        @DisplayName("If the CPF search returns a buyer, it should report an error")
        void buyerWithCPFAlreadyRegistered() {
            //ARRANGE
            var buyer = CompradorFactory.buyerWithCompleteData();

            //ACT
            BDDMockito.given(compradorRepository.findByCpf(buyer.getCpf())).willReturn(Optional.of(buyer));

            //ASSERT
            Assertions.assertThrows(ResponseStatusException.class, ()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do repository com o metodo findById
            verify(compradorRepository, times(1)).findById(buyer.getId());
            verify(compradorRepository, times(1)).findByCpf(buyer.getCpf());

            //garante que NÃO HOUVE interação do repository com os seguintes metodos
            verify(compradorRepository, never()).save(buyer);
        }

        @Test
        @DisplayName("If the CPF search returns a buyer, it should report an error")
        void BuyerRegisteredSuccessfully() {
            //ARRANGE
            var buyer = CompradorFactory.buyerWithCompleteData();

            //ACT
            BDDMockito.given(compradorRepository.findByCpf(buyer.getCpf())).willReturn(Optional.of(buyer));

            //ASSERT
            Assertions.assertDoesNotThrow(()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do repository com o metodo findById
            verify(compradorValidator, times(1)).validateAllDataRegistration(buyer);
            verify(compradorRepository, times(1)).findById(buyer.getId());
            verify(compradorRepository, times(1)).findByCpf(buyer.getCpf());
            verify(compradorRepository, times(1)).save(buyer);

        }

    }

}
