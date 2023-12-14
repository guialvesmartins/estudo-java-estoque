package com.guimartins.produtoapi.controller;

import com.guimartins.produtoapi.exception.RegNaoEncontradoException;
import com.guimartins.produtoapi.model.grupoProduto.GrupoProduto;
import com.guimartins.produtoapi.model.grupoProduto.GrupoProdutoService;
import com.guimartins.produtoapi.model.produto.Produto;
import com.guimartins.produtoapi.model.produto.ProdutoImpl;
import com.guimartins.produtoapi.model.produto.ProdutoRepository;
import com.guimartins.produtoapi.model.produto.ProdutoService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduto(@PathVariable Long id) {
        try{
            Produto produto = produtoService.getProdutoById(id)
                    .orElseThrow(() -> new RegNaoEncontradoException(id));
            return ResponseEntity.ok(produto);
        }catch(RegNaoEncontradoException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        try{
            Optional<Produto> produtoDTO = produtoService.getProdutoById(id);
            if(!produtoDTO.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
            }else{
                produtoService.atualizarProduto(id, produtoAtualizado);
                return ResponseEntity.ok("Atualizado com Sucesso");
            }
        }catch (RuntimeException e ){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
    }
}