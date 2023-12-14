package com.guimartins.produtoapi.controller;

import com.guimartins.produtoapi.model.cliente.Cliente;
import com.guimartins.produtoapi.model.cliente.ClienteService;
import com.guimartins.produtoapi.model.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getGrupo(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public Cliente criarGrupo(@RequestBody Cliente grupo) {
        return clienteService.criarCliente(grupo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarGrupo(@PathVariable Long id, @RequestBody Cliente cliente) {
        try{
            Optional<Cliente> clienteDTO = clienteService.getClienteById(id);
            if(!clienteDTO.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
            }else{
                clienteService.atualizarCliente(id, cliente);
                return ResponseEntity.ok("Atualizado com Sucesso");
            }
        }catch (Exception e ){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping("/{id}")
    public void excluirGrupo(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }
}
