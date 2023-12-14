package com.guimartins.produtoapi.model.itemPedido;

import java.util.List;
import java.util.Optional;

public interface ItemPedidoService {
    List<ItemPedido> getAllItemPedidos();

    Optional<ItemPedido> getItemPedidoById(Long Id);

    ItemPedido criarItemPedido(ItemPedido itemPedido);

    ItemPedido atualizarItemPedido(Long id, ItemPedido itemPedido);

    void excluirItemPedido(Long Id);
}
