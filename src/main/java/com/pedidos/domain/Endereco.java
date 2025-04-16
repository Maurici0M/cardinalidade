package com.pedidos.domain;

import com.pedidos.dto.EditableBuyerDataDTO;
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
    private String numero;
    private String complemento;
    @JoinColumn(name = "cidade_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cidade cidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(String cep, String logradouro, String bairro, String numero, String complemento, Cidade cidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade =
                new Cidade(
                        cidade.getNome(),
                new Estado(
                        cidade.getEstado().getNome()
                ));
        this.uf = uf;
    }

    public Endereco(EditableBuyerDataDTO editableBuyerDataDTO){
        this.cep = editableBuyerDataDTO.getEndereco().getCep();
        this.logradouro = editableBuyerDataDTO.getEndereco().getLogradouro();
        this.bairro = editableBuyerDataDTO.getEndereco().getBairro();
        this.numero = editableBuyerDataDTO.getEndereco().getNumero();
        this.complemento = editableBuyerDataDTO.getEndereco().getComplemento();
        this.cidade = new Cidade(editableBuyerDataDTO);
        this.uf = editableBuyerDataDTO.getEndereco().getUf();
    }

}
