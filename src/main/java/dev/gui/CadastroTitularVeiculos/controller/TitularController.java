package dev.gui.CadastroTitularVeiculos.controller;

import dev.gui.CadastroTitularVeiculos.domain.TitularModel;
import dev.gui.CadastroTitularVeiculos.service.TitularService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titular")
public class TitularController {

    private final TitularService titularService;

    public TitularController(TitularService titularService) {
        this.titularService = titularService;
    }

    @GetMapping("/listar")
    public List<TitularModel> listarTitulares(){
        return titularService.listarTitulares();
    }

    @PostMapping("/criar")
    public TitularModel criarTitular(@RequestBody TitularModel titularModel){
        return titularService.criarTitular(titularModel);
    }

    @GetMapping("/listar/{id}")
    public TitularModel listarTitularId(@PathVariable Long id){
        return titularService.listarTitularId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTitular(@PathVariable Long id){
        titularService.deletarTitular(id);
    }

    @PutMapping("/alterar/{id}")
    public TitularModel alterarInfoTitular(@PathVariable Long id, @RequestBody TitularModel titularModel){
        return titularService.alterarInfoTitular(id, titularModel);
    }

}
