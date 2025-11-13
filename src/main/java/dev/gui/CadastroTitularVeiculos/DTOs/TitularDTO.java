package dev.gui.CadastroTitularVeiculos.DTOs;

import dev.gui.CadastroTitularVeiculos.domain.VeiculoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitularDTO {
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private int numeracaoCarteira;
    private String endereco;
    private List<VeiculoModel> veiculos;
}
