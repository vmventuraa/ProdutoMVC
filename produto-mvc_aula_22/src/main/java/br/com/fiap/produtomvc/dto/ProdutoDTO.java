package br.com.fiap.produtomvc.dto;


import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.models.Loja;
import br.com.fiap.produtomvc.models.Produto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoDTO {


    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @Column(columnDefinition = "TEXT") //para textos longos
    private String descricao;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")
    private Double valor;

    private Categoria categoria;

    private List<Loja> lojas = new ArrayList<Loja>();

    public ProdutoDTO(Produto entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        valor = entity.getValor();
        categoria = entity.getCategoria();
        for (Loja loja : entity.getLojas())
        {
            lojas.add(loja);

        }
    }
}
