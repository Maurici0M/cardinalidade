package com.pedidos.controller;

import com.pedidos.domain.Comprador;
import com.pedidos.service.CompradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comprador")
public class CompradorController {

    private final CompradorService service;

    public CompradorController(CompradorService service) {
        this.service = service;
    }

    @PostMapping
    private ResponseEntity<Comprador> registerBuyer(@RequestBody Comprador comprador) {
            var buyer = service.registerBuyer(comprador);

            return ResponseEntity.ok(buyer);
    }

    @GetMapping
    private ResponseEntity<List<Comprador>> getCompradores() {
        List<Comprador> compradores = service.listarCompradores();

        return ResponseEntity.ok(compradores);
    }
}