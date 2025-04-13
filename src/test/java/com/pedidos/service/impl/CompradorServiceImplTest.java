package com.pedidos.service.impl;

import com.pedidos.factory.CompradorFactory;
import com.pedidos.repository.CompradorRepository;
import com.pedidos.validation.CPFValidator;
import com.pedidos.validation.CompradorValidator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompradorServiceImplTest {

    @Mock
    private CompradorRepository compradorRepository;

    //classe precisa ser mocada no BeforeEach manualmente para evitar erros compilação do teste
    private CompradorValidator compradorValidator;

    @Spy
    private CPFValidator cpfValidator;

    //classe precisa ser mocada no BeforeEach manualmente para evitar erros compilação do teste
    private CompradorServiceImpl compradorService;

    @BeforeEach
    void setUp() {
        compradorValidator = Mockito.spy(new CompradorValidator(cpfValidator)); //adiciona a anotação Spy no compradorValidator e inclui o param do construtor da classe
        compradorService = new CompradorServiceImpl(compradorRepository, compradorValidator); //moca as instâncias necessarias para o funcionamento do service
    }

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
        @DisplayName("If the CPF search returns a buyer, it should report an error")
        void buyerWithCPFAlreadyRegistered() {
            //ARRANGE
            var buyer = CompradorFactory.buyerWithCompleteData();

            //ACT
            BDDMockito.given(compradorRepository.findByCpf(buyer.getCpf())).willReturn(Optional.of(buyer));

            //ASSERT
            Assertions.assertThrows(ResponseStatusException.class, ()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do repository com o metodo findById
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
            Assertions.assertThrows(ResponseStatusException.class ,()-> compradorService.registerBuyer(buyer));

            //garante que HOUVE apenas uma interação do repository com o metodo findById
            verify(compradorValidator, times(1)).validateAllDataRegistration(buyer);
            verify(compradorRepository, times(1)).findByCpf(buyer.getCpf());

            //garante que o metodo save nao foi invocado durante o teste
            verify(compradorRepository, never()).save(buyer);
        }

    }

}
