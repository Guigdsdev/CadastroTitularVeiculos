package dev.gui.CadastroTitularVeiculos.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_titular")
public class TitularModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private int numeracaoCarteira;
    private String endereco;

    @OneToMany(mappedBy = "titular")
    private List<VeiculoModel> veiculos;
}
