package com.pedidos.service.impl;

import com.pedidos.domain.Comprador;
import com.pedidos.dto.BuyerDataDTO;
import com.pedidos.repository.CompradorRepository;
import com.pedidos.service.CompradorService;
import com.pedidos.validation.CompradorValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;

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
    public List<BuyerDataDTO> registerBuyerListForTest(List<Comprador> compradores) {
        List<BuyerDataDTO> buyerList = new LinkedList<>();

        for(Comprador comprador: compradores){

            compradorValidator.validateAllDataRegistration(comprador);

            buyerRepository.findByCpf(comprador.getCpf()).ifPresent(buyer -> {
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "O comprador já está cadastrado. Somente é permitido um cadastro por CPF!");
            });

            var savedBuyer = buyerRepository.save(comprador);

            buyerList.add(new BuyerDataDTO(savedBuyer));

        }

        return buyerList;
    }

    @Override
    public Page<BuyerDataDTO> listAllBuyers(Pageable paginacao) {
        return buyerRepository.findAll(paginacao).map(
                BuyerDataDTO::new
        );
    }

    @Override
    public BuyerDataDTO listBuyerByCPF(Comprador comprador){

        return buyerRepository.findByCpf(comprador.getCpf())
                .map(BuyerDataDTO::new)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Não foi possível encontrar dados de cadastro para o CPF digitado!")
                );

    }

    @Override
    public Comprador listaComprador(int id) {

        return null;
    }

    @Override
    public void deleteBuyerRegistrationByCPF(Comprador comprador) {

        buyerRepository.deleteByCpf(comprador.getCpf()).orElseThrow( () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Não foi possível encontrar dados de cadastro para o CPF digitado!")
        );

    }

}
