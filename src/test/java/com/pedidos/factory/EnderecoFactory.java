package com.pedidos.factory;

import com.pedidos.domain.Endereco;

public class EnderecoFactory {
    public static Endereco enderecoCompleto(){
        var city = CidadeFactory.cidadeCompleta();

        return new Endereco(city, "SP", "Sé", "Praça da Sé", "01001-000");
    }

    public static Endereco enderecoInserirDados(String uf, String bairro, String logradouro, String cep){
        var city = CidadeFactory.cidadeCompleta();

        return new Endereco(city, uf, bairro, logradouro, cep);
    }

}
