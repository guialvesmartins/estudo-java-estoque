package com.guimartins.produtoapi.model.itemPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService{

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public List<ItemPedido> getAllItemPedidos() {
        return itemPedidoRepository.findAll();
    }
    @Override
    public Optional<ItemPedido> getItemPedidoById(Long Id) {
        return itemPedidoRepository.findById(Id);
    }

    @Override
    public ItemPedido criarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    @Override
    public ItemPedido atualizarItemPedido(Long id, ItemPedido itemPedido) {
        if (itemPedidoRepository.existsById(id)) {
            itemPedido.setId(id);
            return itemPedidoRepository.save(itemPedido);
        } else {
            throw new IllegalArgumentException("Produto não encontrado com o ID: " + id);
        }
    }

    @Override
    public void excluirItemPedido(Long Id) {
        itemPedidoRepository.deleteById(Id);
    }

}
