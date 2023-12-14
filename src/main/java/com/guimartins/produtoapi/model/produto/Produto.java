package com.guimartins.produtoapi.model.produto;
import com.guimartins.produtoapi.model.grupoProduto.GrupoProduto;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double preco;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private GrupoProduto grupoProduto;
}