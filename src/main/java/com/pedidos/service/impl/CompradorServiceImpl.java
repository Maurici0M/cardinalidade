package com.pedidos.service.impl;

import com.pedidos.domain.Comprador;
import com.pedidos.domain.Endereco;
import com.pedidos.repository.CompradorRepository;
import com.pedidos.repository.EnderecoRepository;
import com.pedidos.service.CompradorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompradorServiceImpl implements CompradorService {

    private final CompradorRepository repository;
    private final EnderecoRepository enderecoRepository;

    private final Logger log = LoggerFactory.getLogger(CompradorServiceImpl.class);

    public CompradorServiceImpl(CompradorRepository repository, EnderecoRepository enderecoRepository) {
        this.repository = repository;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Comprador criarComprador(Comprador comprador) {
        if (Objects.nonNull(comprador.getEnderecos()) && !comprador.getEnderecos().isEmpty()) {
            List<Endereco> enderecos = enderecoRepository.saveAll(comprador.getEnderecos());
            log.info("");
        }
        Comprador c = repository.save(comprador);
        log.info("");
        return c;
    }

    @Override
    public List<Comprador> listarCompradores() {
        return repository.findAll();
    }

    @Override
    public Comprador listaComprador(int id) {
        return null;
    }
}