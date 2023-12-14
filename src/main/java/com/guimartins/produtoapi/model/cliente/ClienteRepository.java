package com.guimartins.produtoapi.model.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}