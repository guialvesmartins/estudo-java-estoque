package com.guimartins.produtoapi.model.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private  PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }
    @Override
    public Optional<Pedido> getPedidoById(Long Id) {
        return pedidoRepository.findById(Id);
    }
    @Override
    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido atualizarPedido(Long id, Pedido pedido) {
        if (pedidoRepository.existsById(id)) {
            pedido.setId(id);
            return pedidoRepository.save(pedido);
        } else {
            throw new IllegalArgumentException("Produto não encontrado com o ID: " + id);
        }
    }

    @Override
    public void excluirPedido(Long Id) {
        pedidoRepository.deleteById(Id);
    }
}
