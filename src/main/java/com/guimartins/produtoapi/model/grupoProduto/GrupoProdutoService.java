package com.guimartins.produtoapi.model.grupoProduto;

import java.util.List;
import java.util.Optional;

public interface GrupoProdutoService {
    List<GrupoProduto> getAllGrupoProdutos();
    Optional<GrupoProduto> getGrupoProdutoById(Long Id);
    GrupoProduto criarGrupo(GrupoProduto grupoProduto);
    GrupoProduto atualizarGrupo(Long Id, GrupoProduto grupoProduto);
    void excluirGrupo(Long Id);

}
