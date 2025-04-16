package com.pedidos.service;

import com.pedidos.domain.Comprador;
import com.pedidos.dto.BuyerDataDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompradorService {

    BuyerDataDTO registerBuyer(Comprador comprador);

    List<BuyerDataDTO> registerBuyerListForTest(List<Comprador> compradores);

    Page<BuyerDataDTO> listAllBuyers(Pageable paginacao);

    Comprador listaComprador(int id);

}
