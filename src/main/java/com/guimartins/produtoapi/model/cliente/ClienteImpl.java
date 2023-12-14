package com.guimartins.produtoapi.model.cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    @Override
    public Optional<Cliente> getClienteById(Long Id) {
        return clienteRepository.findById(Id);
    }
    @Override
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizarCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("Produto não encontrado com o ID: " + id);
        }
    }

    @Override
    public void excluirCliente(Long Id) {
        clienteRepository.deleteById(Id);
    }
}
