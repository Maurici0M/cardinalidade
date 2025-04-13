package com.pedidos.controller;

import com.pedidos.domain.Comprador;
import com.pedidos.service.CompradorService;
import com.pedidos.validation.CompradorValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comprador")
public class CompradorController {

    private final CompradorValidator compradorValidator;
    private final CompradorService service;

    public CompradorController(CompradorValidator compradorValidator, CompradorService service) {
        this.compradorValidator = compradorValidator;
        this.service = service;
    }

    @PostMapping
    private ResponseEntity<Comprador> criarComprador(@RequestBody Comprador comprador) {
        compradorValidator.validateAllDataRegistration(comprador);

        Comprador c = service.registerBuyer(comprador);

        return ResponseEntity.ok(c);
    }

    @GetMapping
    private ResponseEntity<List<Comprador>> getCompradores() {
        List<Comprador> compradores = service.listarCompradores();

        return ResponseEntity.ok(compradores);
    }
}