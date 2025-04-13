package com.pedidos.repository;

import com.pedidos.domain.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Integer> {
    Optional<Comprador> findByCpf(String cpf);

}