package com.guimartins.produtoapi.model.pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> getAllPedidos();

    Optional<Pedido> getPedidoById(Long Id);

    Pedido criarPedido(Pedido produto);

    Pedido atualizarPedido(Long Id, Pedido produto);

    void excluirPedido(Long Id);
}
