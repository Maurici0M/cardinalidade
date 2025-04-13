package com.pedidos.service.impl;

import com.pedidos.domain.Comprador;
import com.pedidos.dto.BuyerDataDTO;
import com.pedidos.repository.CompradorRepository;
import com.pedidos.service.CompradorService;
import com.pedidos.validation.CompradorValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompradorServiceImpl implements CompradorService {

    private final CompradorRepository buyerRepository;
    private final CompradorValidator compradorValidator;

    private final Logger log = LoggerFactory.getLogger(CompradorServiceImpl.class);

    public CompradorServiceImpl(CompradorRepository buyerRepository, CompradorValidator compradorValidator) {
        this.buyerRepository = buyerRepository;
        this.compradorValidator = compradorValidator;
    }

    @Override
    public BuyerDataDTO registerBuyer(Comprador comprador) {
        compradorValidator.validateAllDataRegistration(comprador);

        buyerRepository.findByCpf(comprador.getCpf()).ifPresent(buyer -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "O comprador já está cadastrado. Somente é permitido um cadastro por CPF!");
        });

        var savedBuyer = buyerRepository.save(comprador);

        return new BuyerDataDTO(savedBuyer);
    }

    @Override
    public List<BuyerDataDTO> listarCompradores() {
        return buyerRepository.findAll().stream().map(
                BuyerDataDTO::new
        ).collect(Collectors.toList());
    }

    @Override
    public Comprador listaComprador(int id) {

        return null;
    }

}
