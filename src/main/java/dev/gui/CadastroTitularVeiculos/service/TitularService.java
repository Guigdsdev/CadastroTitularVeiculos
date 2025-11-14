package dev.gui.CadastroTitularVeiculos.service;

import dev.gui.CadastroTitularVeiculos.DTOs.TitularDTO;
import dev.gui.CadastroTitularVeiculos.domain.TitularModel;
import dev.gui.CadastroTitularVeiculos.mappers.MapperTitular;
import dev.gui.CadastroTitularVeiculos.repository.TitularRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TitularService {

    private final TitularRepository titularRepository;
    private final MapperTitular mapper;

    public TitularService(TitularRepository titularRepository, MapperTitular mapper) {
        this.titularRepository = titularRepository;
        this.mapper = mapper;
    }

    public List<TitularDTO> listarTitulares(){
        List<TitularModel> titulares = titularRepository.findAll();
        return titulares.stream().map(mapper::map).collect(Collectors.toList());
    }

    public TitularDTO criarTitular(TitularDTO titularDTO){
        TitularModel titular = mapper.map(titularDTO);
        titularRepository.save(titular);
        return mapper.map(titular);
    }

    public TitularDTO listarTitularId(Long id){
        Optional<TitularModel> titularId = titularRepository.findById(id);
        return titularId.map(mapper::map).orElse(null);
    }

    public TitularDTO deletarTitular(Long id){
        if(titularRepository.existsById(id)) {
            titularRepository.deleteById(id);
        }
        return null;
    }

    public TitularDTO alterarInfoTitular(Long id, TitularDTO titularDTO){
        Optional<TitularModel> titular = titularRepository.findById(id);
        titular.get().setId(id);
      return titular.map(mapper::map).orElse(null);
    }

}
