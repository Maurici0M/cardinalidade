package com.pedidos.domain;

import com.pedidos.dto.BuyerAddressDataDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public Estado() {
    }

    public Estado(String nome) {
        this.nome = nome;
    }

    public Estado(BuyerAddressDataDTO buyerAddressDataDTO) {
        this.nome = buyerAddressDataDTO.getEstado();
    }

}