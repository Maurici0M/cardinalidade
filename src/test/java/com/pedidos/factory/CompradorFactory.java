package com.pedidos.factory;

import com.pedidos.domain.Comprador;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

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

    public static List<Comprador> buyerListWithCompleteData(){
        List<Comprador> buyerList = new LinkedList<>();
        var buyer1 = buyerInsertPersonalData("Elisa", "Alves", LocalDate.of(1985, 3, 17), "12345678900");
        var buyer2 = buyerInsertPersonalData("Chris", "Redfield", LocalDate.of(1990, 8, 25), "12345678901");
        var buyer3 = buyerInsertPersonalData("Jill", "Valantine", LocalDate.of(1995, 11, 28), "12345678902");

        buyerList.add(buyer1);
        buyerList.add(buyer2);
        buyerList.add(buyer3);

        return buyerList;
    }

}
