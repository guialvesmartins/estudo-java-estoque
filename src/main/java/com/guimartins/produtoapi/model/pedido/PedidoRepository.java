package com.guimartins.produtoapi.model.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}