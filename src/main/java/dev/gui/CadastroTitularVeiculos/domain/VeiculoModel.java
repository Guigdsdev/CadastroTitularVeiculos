package dev.gui.CadastroTitularVeiculos.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculos")
public class VeiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "ano")
    private int ano;

    @Column(name = "km")
    private double km;

    @Column(name = "velocidade_maxima")
    private int velocidadeMaxima;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "id_titular")
    private TitularModel titular;
}
