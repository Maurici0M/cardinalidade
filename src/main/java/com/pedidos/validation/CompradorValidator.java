package com.pedidos.validation;

import com.pedidos.domain.Comprador;
import com.pedidos.domain.Endereco;
import com.pedidos.dto.EditableBuyerDataDTO;
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

    /*------ Validation logics ------*/

    //Emitirá validações dos campos de cadastro de forma reutilizável;
    public void validateDataFieldRegistration(String field, String fieldName){
        if (Objects.isNull(field) || field.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O campo " + fieldName.toUpperCase() + " é obrigatório e não pode estar vazio!");
        }
    }

    //Irá validar a idade
    public void validateAge(LocalDate dataDeNascimento){
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

    //validará a quantidade de caracteres dos campos
    public void validAmountCharacters(String field, String fieldName, int numberCharacters){
        if (field.trim().length() < numberCharacters){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O campo " + fieldName.toUpperCase() + " precisa ter no mínimo " + numberCharacters + " caracteres!");
        }
    }

    //validará campos de dados pessoais
    public void validatePersonalDataFields(Comprador comprador){
        validateDataFieldRegistration(comprador.getNome(), "nome");

        validAmountCharacters(comprador.getNome(), "nome",3);

        validateDataFieldRegistration(comprador.getSobrenome(), "sobrenome");

        validAmountCharacters(comprador.getSobrenome(), "sobrenome", 3);

        validateAge(comprador.getDataNascimento()); //validará a idade

        cpfValidator.checkCPF(comprador.getCpf());
    }

    //validará campos do endereço
    public void validateRegistrationDataAddress(Endereco endereco){

        if (Objects.isNull(endereco)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Os dados de endereço são obrigatórios e não podem estar vazio!");
        }

        validateDataFieldRegistration(endereco.getCep(), "cep");
        validateDataFieldRegistration(endereco.getLogradouro(), "logradouro");
        validateDataFieldRegistration(endereco.getBairro(), "bairro");
        validateDataFieldRegistration(endereco.getNumero(), "número");
        validateDataFieldRegistration(endereco.getComplemento(), "complemento");
        validateDataFieldRegistration(endereco.getUf(), "uf");
        validateDataFieldRegistration(endereco.getCidade().getNome(), "cidade");
        validateDataFieldRegistration(endereco.getCidade().getEstado().getNome(), "estado");
    }

    //validará campos para edição do endereço
    public void validAddressEditRegistration(EditableBuyerDataDTO buyerDataEditableDTO){
        if (Objects.isNull(buyerDataEditableDTO)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Os dados de endereço são obrigatórios e não podem estar vazio!");
        }

        validateDataFieldRegistration(buyerDataEditableDTO.getEndereco().getCep(), "cep");
        validAmountCharacters(buyerDataEditableDTO.getEndereco().getCep(), "cep",8);

        validateDataFieldRegistration(buyerDataEditableDTO.getEndereco().getLogradouro(), "logradouro");
        validateDataFieldRegistration(buyerDataEditableDTO.getEndereco().getBairro(), "bairro");
        validateDataFieldRegistration(buyerDataEditableDTO.getEndereco().getNumero(), "número");
        validateDataFieldRegistration(buyerDataEditableDTO.getEndereco().getComplemento(), "complemento");
        validateDataFieldRegistration(buyerDataEditableDTO.getEndereco().getUf(), "uf");
        validateDataFieldRegistration(buyerDataEditableDTO.getEndereco().getCidade(), "cidade");
        validateDataFieldRegistration(buyerDataEditableDTO.getEndereco().getEstado(), "estado");
    }

    /*------ Validator methods ------*/

    //valida todos os campos de cadastro
    public void validateAllDataRegistration(Comprador comprador){
        validatePersonalDataFields(comprador); //valida os dados pessoais

        validateRegistrationDataAddress(comprador.getEndereco()); //valida os dados de endereço
    }

    //valida os campos de edição do endereço de cadastro
    public void editBuyerRegistration(EditableBuyerDataDTO buyerDataEditableDTO){
        validAddressEditRegistration(buyerDataEditableDTO);
    }

}
