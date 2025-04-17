package com.pedidos.validation;

import com.pedidos.domain.Comprador;
import com.pedidos.domain.Endereco;
import com.pedidos.dto.BuyerEditableDataDTO;
import com.pedidos.util.ToEnderecoFormatterUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Component
public class CompradorValidator {

    private final CPFValidator cpfValidator;

    public CompradorValidator(CPFValidator cpfValidator) {
        this.cpfValidator = cpfValidator;
    }

    //--------------------------- Validation logics ------------------------------------------------

    public void validateDataFieldRegistration(String field, String fieldName){
        //Emitirá validações dos campos de cadastro de forma reutilizável;

        if (Objects.isNull(field) || field.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O campo " + fieldName.toUpperCase() + " é obrigatório e não pode estar vazio!");
        }
    }

    public void validateAge(LocalDate dataDeNascimento){
        //Irá validar a idade

        if (Objects.isNull(dataDeNascimento)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O campo data de nascimento é de preenchimento obrigatório e não pode estar vazio!");
        }

        LocalDate dataAtual = LocalDate.now();

        int idade = Period.between(dataDeNascimento, dataAtual).getYears();

        if (idade < 18 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "É necessário ter no mínimo 18 anos para se cadastrar na plataforma!");
        }
    }

    public void validAmountCharacters(String field, String fieldName, int numberCharacters){
        //validará a quantidade de caracteres dos campos

        if (field.trim().length() < numberCharacters){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O campo " + fieldName.toUpperCase() + " precisa ter no mínimo " + numberCharacters + " caracteres!");
        }
    }

    public void validatePersonalDataFields(Comprador comprador){
        //validará campos de dados pessoais

        validateDataFieldRegistration(comprador.getNome(), "nome");

        validAmountCharacters(comprador.getNome(), "nome",3);

        validateDataFieldRegistration(comprador.getSobrenome(), "sobrenome");

        validAmountCharacters(comprador.getSobrenome(), "sobrenome", 3);

        validateAge(comprador.getDataNascimento()); //validará a idade

        cpfValidator.checkCPF(comprador.getCpf());
    }

    public void validateRegistrationDataAddress(Endereco endereco){
        //validará campos do endereço

        if (Objects.isNull(endereco)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Os dados de endereço são obrigatórios e não podem estar vazio!");
        }

        validateDataFieldRegistration(endereco.getCep(), "cep");
        validAmountCharacters(endereco.getCep(), "cep",8);

        validateDataFieldRegistration(endereco.getLogradouro(), "logradouro");
        validateDataFieldRegistration(endereco.getBairro(), "bairro");
        validateDataFieldRegistration(endereco.getNumero(), "número");
        validateDataFieldRegistration(endereco.getComplemento(), "complemento");
        validateDataFieldRegistration(endereco.getUf(), "uf");
        validateDataFieldRegistration(endereco.getCidade().getNome(), "cidade");
        validateDataFieldRegistration(endereco.getCidade().getEstado().getNome(), "estado");
    }

    //--------------------------- Validator methods ------------------------------------------------

    public void validateAllDataRegistration(Comprador comprador){
        //valida todos os campos de cadastro

        validatePersonalDataFields(comprador); //valida os dados pessoais

        validateRegistrationDataAddress(comprador.getEndereco()); //valida os dados de endereço
    }

    public void editBuyerRegistration(BuyerEditableDataDTO buyerDataEditableDTO){
        //valida os campos de edição do endereço de cadastro

        validateRegistrationDataAddress(
                ToEnderecoFormatterUtil.formatBuyerEditableDataDTOtoAddress(buyerDataEditableDTO)
        );
    }

}
