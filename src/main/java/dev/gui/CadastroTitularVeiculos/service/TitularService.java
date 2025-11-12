package dev.gui.CadastroTitularVeiculos.service;

import dev.gui.CadastroTitularVeiculos.domain.TitularModel;
import dev.gui.CadastroTitularVeiculos.repository.TitularRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitularService {

    private final TitularRepository titularRepository;

    public TitularService(TitularRepository titularRepository) {
        this.titularRepository = titularRepository;
    }

    public List<TitularModel> listarTitulares(){
        List<TitularModel> titulares = titularRepository.findAll();
        return titulares;
    }
}
