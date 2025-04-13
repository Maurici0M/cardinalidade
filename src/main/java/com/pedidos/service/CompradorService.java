package com.pedidos.service;

import com.pedidos.domain.Comprador;
import com.pedidos.dto.BuyerDataDTO;

import java.util.List;

public interface CompradorService {

    BuyerDataDTO registerBuyer(Comprador comprador);

    List<BuyerDataDTO> listarCompradores();

    Comprador listaComprador(int id);
}