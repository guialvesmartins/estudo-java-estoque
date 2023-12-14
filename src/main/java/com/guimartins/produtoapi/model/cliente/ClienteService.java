package com.guimartins.produtoapi.model.cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Optional<Cliente> getClienteById(Long Id);
    Cliente criarCliente(Cliente produto);
    Cliente atualizarCliente(Long Id, Cliente produto);
    void excluirCliente(Long Id);
}
