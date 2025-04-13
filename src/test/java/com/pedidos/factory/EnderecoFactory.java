package com.pedidos.factory;

import com.pedidos.domain.Endereco;

public class EnderecoFactory {
    public static Endereco enderecoCompleto(){
        var city = CidadeFactory.cidadeCompleta();

        return new Endereco("01001-000", "Praça da Sé", "Sé", "4875", "CS 1", city, "SP");
    }

    public static Endereco enderecoInserirDados(String cep, String logradouro, String bairro, String numero, String complemento, String uf){
        var city = CidadeFactory.cidadeCompleta();

        return new Endereco(cep, logradouro, bairro, numero, complemento, city, uf);
    }

}
