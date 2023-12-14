package com.guimartins.produtoapi.model.produto;

import com.guimartins.produtoapi.model.grupoProduto.GrupoProduto;
import com.guimartins.produtoapi.model.grupoProduto.GrupoProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    public ProdutoImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    @Override
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }
    @Override
    public Optional<Produto> getProdutoById(Long Id) {
        return produtoRepository.findById(Id);
    }
    @Override
    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto atualizarProduto(Long id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        } else {
            throw new IllegalArgumentException("Produto não encontrado com o ID: " + id);
        }
    }

    @Override
    public void excluirProduto(Long Id) {
        produtoRepository.deleteById(Id);
    }
}
