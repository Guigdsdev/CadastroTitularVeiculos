package dev.gui.CadastroTitularVeiculos.service;

import dev.gui.CadastroTitularVeiculos.domain.TitularModel;
import dev.gui.CadastroTitularVeiculos.repository.TitularRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public TitularModel criarTitular(TitularModel titularModel){
        return titularRepository.save(titularModel);
    }

    public TitularModel listarTitularId(Long id){
        Optional<TitularModel> titularId = titularRepository.findById(id);
        return titularId.orElse(null);
    }
}
