package com.pedidos.controller;

import com.pedidos.domain.Comprador;
import com.pedidos.dto.BuyerDataDTO;
import com.pedidos.dto.BuyerEditableDataDTO;
import com.pedidos.service.CompradorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public ResponseEntity<BuyerDataDTO> registerBuyer(@RequestBody Comprador comprador) {
        var buyer = service.registerBuyer(comprador);

        return ResponseEntity.ok(buyer);
    }

    @PostMapping("/array")
    @Transactional
    public ResponseEntity<List<BuyerDataDTO>> registerBuyerListForTest(@RequestBody List<Comprador> listaCompradores){
        var buyerList = service.registerBuyerListForTest(listaCompradores);

        return ResponseEntity.ok(buyerList);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public Page<BuyerDataDTO> listAllBuyers(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return service.listAllBuyers(paginacao);
    }

    @GetMapping("listar/cpf")
    @Transactional(readOnly = true)
    public ResponseEntity<BuyerDataDTO> listBuyerByCPF(@RequestBody Comprador comprador) {
        var buyer = service.listBuyerByCPF(comprador.getCpf());

        return ResponseEntity.ok(buyer);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deleteBuyerRegistration(@RequestBody Comprador comprador){
        service.deleteBuyerRegistrationByCPF(comprador);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> editBuyerRegistration(@RequestBody BuyerEditableDataDTO buyerDataEditableDTO){
        service.editBuyerRegistration(buyerDataEditableDTO);

        return ResponseEntity.noContent().build();
    }

}
