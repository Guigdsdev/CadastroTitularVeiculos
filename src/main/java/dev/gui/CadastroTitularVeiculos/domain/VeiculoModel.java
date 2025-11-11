package dev.gui.CadastroTitularVeiculos.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculos")
public class VeiculosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String marca;
    private int ano;
    private double km;
    private int velocidadeMaxima;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "id_titular")
    private TitularModel titularModel;
}
