package dev.gui.CadastroTitularVeiculos.mappers;

import dev.gui.CadastroTitularVeiculos.DTOs.VeiculoDTO;
import dev.gui.CadastroTitularVeiculos.domain.VeiculoModel;
import org.springframework.stereotype.Component;

@Component
public class MapperVeiculo {

    public VeiculoModel map(VeiculoDTO veiculoDTO){
        VeiculoModel veiculoModel = new VeiculoModel();
        veiculoModel.setId(veiculoDTO.getId());
        veiculoModel.setModelo(veiculoDTO.getModelo());
        veiculoModel.setMarca(veiculoDTO.getMarca());
        veiculoModel.setAno(veiculoDTO.getAno());
        veiculoModel.setKm(veiculoDTO.getKm());
        veiculoModel.setVelocidadeMaxima(veiculoDTO.getVelocidadeMaxima());
        veiculoModel.setImgUrl(veiculoDTO.getImgUrl());
        veiculoModel.setTitular(veiculoDTO.getTitular());
        return veiculoModel;
    }

    public VeiculoDTO map(VeiculoModel veiculoModel){
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setId(veiculoModel.getId());
        veiculoDTO.setModelo(veiculoModel.getModelo());
        veiculoDTO.setMarca(veiculoModel.getMarca());
        veiculoDTO.setAno(veiculoModel.getAno());
        veiculoDTO.setKm(veiculoModel.getKm());
        veiculoDTO.setVelocidadeMaxima(veiculoModel.getVelocidadeMaxima());
        veiculoDTO.setImgUrl(veiculoModel.getImgUrl());
        veiculoDTO.setTitular(veiculoModel.getTitular());
        return veiculoDTO;
    }

}
