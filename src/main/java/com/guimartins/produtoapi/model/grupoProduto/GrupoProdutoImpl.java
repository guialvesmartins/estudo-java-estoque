package com.guimartins.produtoapi.model.grupoProduto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoProdutoImpl implements GrupoProdutoService {

    private final GrupoProdutoRepository grupoProdutoRepository;
    public GrupoProdutoImpl(GrupoProdutoRepository grupoProdutoRepository) {
        this.grupoProdutoRepository = grupoProdutoRepository;
    }

    @Override
    public List<GrupoProduto> getAllGrupoProdutos() {
        return grupoProdutoRepository.findAll();
    }

    @Override
    public Optional<GrupoProduto> getGrupoProdutoById(Long id) {
        return grupoProdutoRepository.findById(id);
    }

    @Override
    public GrupoProduto criarGrupo(GrupoProduto grupoProduto) {
        return grupoProdutoRepository.save(grupoProduto);
    }

    @Override
    public GrupoProduto atualizarGrupo(Long id, GrupoProduto grupoProduto) {
        if (grupoProdutoRepository.existsById(id)) {
            grupoProduto.setId(id);
            return grupoProdutoRepository.save(grupoProduto);
        } else {
            throw new IllegalArgumentException("Produto não encontrado com o ID: " + id);
        }
    }

    @Override
    public void excluirGrupo(Long Id) {
        grupoProdutoRepository.deleteById(Id);
    }
}
