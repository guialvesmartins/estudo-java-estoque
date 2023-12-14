package com.guimartins.produtoapi.controller;
import com.guimartins.produtoapi.model.pedido.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> getGrupo(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public Pedido criarGrupo(@RequestBody Pedido grupo) {
        return pedidoService.criarPedido(grupo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarGrupo(@PathVariable Long id, @RequestBody Pedido pedido) {
        try{
            Optional<Pedido> pedidoDTO = pedidoService.getPedidoById(id);
            if(!pedidoDTO.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
            }else{
                pedidoService.atualizarPedido(id, pedido);
                return ResponseEntity.ok("Atualizado com Sucesso");
            }
        }catch (Exception e ){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping("/{id}")
    public void excluirGrupo(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
    }
}


