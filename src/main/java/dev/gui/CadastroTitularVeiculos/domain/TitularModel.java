package dev.gui.CadastroTitularVeiculos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_titular")
@ToString
public class TitularModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "numeracao_carteira")
    private int numeracaoCarteira;

    @Column(name = "endereco")
    private String endereco;

    @OneToMany(mappedBy = "titular")
    @JsonIgnore
    private List<VeiculoModel> veiculos;
}
