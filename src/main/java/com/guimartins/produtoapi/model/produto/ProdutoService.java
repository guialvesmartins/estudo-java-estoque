package com.guimartins.produtoapi.model.produto;

import com.guimartins.produtoapi.model.grupoProduto.GrupoProduto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    List<Produto> getAllProdutos();
    Optional<Produto> getProdutoById(Long Id);
    Produto criarProduto(Produto produto);
    Produto atualizarProduto(Long Id, Produto produto);
    void excluirProduto(Long Id);
}
