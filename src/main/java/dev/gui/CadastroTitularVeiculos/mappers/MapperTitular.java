package dev.gui.CadastroTitularVeiculos.mappers;

import dev.gui.CadastroTitularVeiculos.DTOs.TitularDTO;
import dev.gui.CadastroTitularVeiculos.domain.TitularModel;

public class MapperTitular {

    public TitularModel map(TitularDTO titularDTO){
        TitularModel titularModel = new TitularModel();
        titularModel.setId(titularDTO.getId());
    }

    public TitularDTO map(TitularModel titularModel){
        TitularDTO titularDTO = new TitularDTO();
        titularDTO.setId(titularModel.getId());
        titularDTO.setEmail(titularModel.getEmail());
        titularDTO.setNome(titularModel.getNome());
        titularDTO.setIdade(titularModel.getIdade());
        titularDTO.setNumeracaoCarteira(titularModel.getNumeracaoCarteira());
        titularDTO.setEndereco(titularModel.getEndereco());
        titularDTO.setVeiculos(titularModel.getVeiculos());
        return titularDTO;
    }
}
