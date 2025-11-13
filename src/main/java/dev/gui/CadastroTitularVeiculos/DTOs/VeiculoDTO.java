package dev.gui.CadastroTitularVeiculos.DTOs;

import dev.gui.CadastroTitularVeiculos.domain.TitularModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {

    private Long id;
    private String modelo;
    private String marca;
    private int ano;
    private double km;
    private int velocidadeMaxima;
    private String imgUrl;
    private TitularModel titular;
}
