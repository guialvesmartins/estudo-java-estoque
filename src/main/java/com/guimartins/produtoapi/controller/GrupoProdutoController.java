package com.guimartins.produtoapi.controller;
import com.guimartins.produtoapi.model.grupoProduto.GrupoProduto;
import com.guimartins.produtoapi.model.grupoProduto.GrupoProdutoService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos")
public class GrupoProdutoController {
    private final GrupoProdutoService grupoProdutoService;

    @Autowired
    public GrupoProdutoController(GrupoProdutoService grupoProdutoService) {
        this.grupoProdutoService = grupoProdutoService;
    }


    @GetMapping
    public List<GrupoProduto> getAllGrupos() {
        return grupoProdutoService.getAllGrupoProdutos();
    }

    @GetMapping("/{id}")
    public Optional<GrupoProduto> getGrupo(@PathVariable Long id) {
        return grupoProdutoService.getGrupoProdutoById(id);
    }

    @PostMapping
    public GrupoProduto criarGrupo(@RequestBody GrupoProduto grupo) {
        return grupoProdutoService.criarGrupo(grupo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarGrupo(@PathVariable Long id, @RequestBody GrupoProduto grupoProduto) {
        try{
            Optional<GrupoProduto> grupoProdutoDTO = grupoProdutoService.getGrupoProdutoById(id);
            if(!grupoProdutoDTO.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
            }else{
                grupoProdutoService.atualizarGrupo(id, grupoProduto);
                return ResponseEntity.ok("Atualizado com Sucesso");
            }
        }catch (Exception e ){
          return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping("/{id}")
    public void excluirGrupo(@PathVariable Long id) {
        grupoProdutoService.excluirGrupo(id);
    }
}