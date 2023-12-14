package com.guimartins.produtoapi.model.itemPedido;
import com.guimartins.produtoapi.model.pedido.Pedido;
import com.guimartins.produtoapi.model.produto.Produto;
import javax.persistence.Id;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Produto produto;
    private int quantidade;

}
