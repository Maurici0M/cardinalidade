package com.pedidos.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "comprador")
    @ManyToOne
    private Comprador comprador;
    private LocalDateTime data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}