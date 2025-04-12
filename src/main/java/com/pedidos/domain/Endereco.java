package com.pedidos.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String logradouro;
    private String cep;
    @JoinColumn(name = "cidade")
    @ManyToOne
    private Cidade cidade;

    public Endereco() {
    }

}
