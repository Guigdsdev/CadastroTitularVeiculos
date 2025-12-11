package dev.gui.CadastroTitularVeiculos.service;

import dev.gui.CadastroTitularVeiculos.DTOs.VeiculoDTO;
import dev.gui.CadastroTitularVeiculos.domain.VeiculoModel;
import dev.gui.CadastroTitularVeiculos.mappers.MapperVeiculo;
import dev.gui.CadastroTitularVeiculos.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final MapperVeiculo mapperVeiculo;

    public VeiculoService(VeiculoRepository veiculoRepository, MapperVeiculo mapperVeiculo) {
        this.veiculoRepository = veiculoRepository;
        this.mapperVeiculo = mapperVeiculo;
    }

    public List<VeiculoDTO> listarVeiculos() {
        List<VeiculoModel> veiculos = veiculoRepository.findAll();
        return veiculos.stream().map(mapperVeiculo::map).collect(Collectors.toList());
    }

    public VeiculoDTO criarVeiculo(VeiculoDTO veiculoDTO){
        VeiculoModel veiculo = new VeiculoModel();
        veiculo = mapperVeiculo.map(veiculoDTO);
        veiculoRepository.save(veiculo);
        return mapperVeiculo.map(veiculo);
    }

    public VeiculoDTO listarVeiculoId(Long id){
        Optional<VeiculoModel> veiculo= veiculoRepository.findById(id);
        return veiculo.map(mapperVeiculo::map).orElse(null);
    }

    public VeiculoDTO removerVeiculo(Long id){
        VeiculoDTO veiculo = listarVeiculoId(id);
        if(veiculo != null) {
            veiculoRepository.deleteById(id);
        }
        return null;
    }
}
