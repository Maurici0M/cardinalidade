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
    private Integer id;
    private String cep;
    private String logradouro;
    private String bairro;
    @JoinColumn(name = "cidade_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cidade cidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(Cidade cidade, String uf, String bairro, String logradouro, String cep) {
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.cep = cep;
    }
}
