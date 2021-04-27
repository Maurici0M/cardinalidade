package com.pedidos.service;

import com.pedidos.domain.Comprador;

import java.util.List;

public interface CompradorService {

    Comprador criarComprador(Comprador comprador);

    List<Comprador> listarCompradores();

    Comprador listaComprador(int id);
}