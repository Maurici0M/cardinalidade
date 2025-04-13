package com.pedidos.factory;

import com.pedidos.domain.Comprador;

import java.time.LocalDate;

public class CompradorFactory {

    public static Comprador buyerWithCompleteData(){
        var endereco = EnderecoFactory.enderecoCompleto();

        return new Comprador(
                "Ada",
                "Wong",
                LocalDate.of(1990, 11, 25),
                "12345678901",
                endereco
        );
    }

    public static Comprador buyerInsertPersonalData(String nome, String sobrenome, LocalDate idade, String cpf){
        var endereco = EnderecoFactory.enderecoCompleto();

        return new Comprador(
                nome,
                sobrenome,
                idade,
                cpf,
                endereco
        );
    }

    public static Comprador buyerInsertAderessData(String cep, String logradouro, String bairro, String numero, String complemento, String uf){
        var endereco = EnderecoFactory.enderecoInserirDados(
                cep, logradouro, bairro, numero, complemento, uf);

        return new Comprador(
                "Ada",
                "Wong",
                LocalDate.of(1990, 11, 25),
                "12345678901",
                endereco
        );
    }

}
