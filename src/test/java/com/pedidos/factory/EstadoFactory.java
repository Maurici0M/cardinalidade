package com.pedidos.factory;

import com.pedidos.domain.Estado;

public class EstadoFactory {
    public static Estado estadoCompleto(){

        return new Estado("São Paulo");
    }

}
