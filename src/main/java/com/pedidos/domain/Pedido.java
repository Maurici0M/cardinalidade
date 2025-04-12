package com.pedidos.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
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

    public Pedido() {
    }

}