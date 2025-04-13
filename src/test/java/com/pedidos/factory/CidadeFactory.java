package com.pedidos.factory;

import com.pedidos.domain.Cidade;

public class CidadeFactory {
    public static Cidade cidadeCompleta(){
        var estado = EstadoFactory.estadoCompleto();

        return new Cidade("São Paulo", estado);
    }

}
