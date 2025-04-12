package com.pedidos.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "comprador")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String sobrenome;
    private int idade;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "comprador_endereco", joinColumns = {
            @JoinColumn(name = "comprador")}, inverseJoinColumns = {
            @JoinColumn(name = "endereco")})
    private Set<Endereco> enderecos;

    public Comprador() {
    }

}