package com.pedidos.domain;

import javax.persistence.*;
import java.util.Set;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> endereco) {
        this.enderecos = enderecos;
    }
}