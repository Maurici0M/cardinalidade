package com.pedidos.domain;

import com.pedidos.dto.BuyerAddressDataDTO;
import com.pedidos.dto.EditableBuyerDataDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @JoinColumn(name = "estado_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Estado estado;

    public Cidade() {
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public Cidade(BuyerAddressDataDTO buyerAddressDataDTO){
        this.nome = buyerAddressDataDTO.getCidade();
        this.estado = new Estado(buyerAddressDataDTO);
    }

    public Cidade(EditableBuyerDataDTO editableBuyerDataDTO){
        this.nome = editableBuyerDataDTO.getEndereco().getCidade();
        this.estado = new Estado(editableBuyerDataDTO.getEndereco().getEstado());
    }

}
