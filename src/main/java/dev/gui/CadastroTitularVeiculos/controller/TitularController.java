package dev.gui.CadastroTitularVeiculos.controller;

import dev.gui.CadastroTitularVeiculos.DTOs.TitularDTO;
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
    public List<TitularDTO> listarTitulares(){
        return titularService.listarTitulares();
    }

    @PostMapping("/criar")
    public TitularDTO criarTitular(@RequestBody TitularDTO titularDTO){
        return titularService.criarTitular(titularDTO);
    }

    @GetMapping("/listar/{id}")
    public TitularDTO listarTitularId(@PathVariable Long id){
        return titularService.listarTitularId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTitular(@PathVariable Long id){
        titularService.deletarTitular(id);
    }

    @PutMapping("/alterar/{id}")
    public TitularDTO alterarInfoTitular(@PathVariable Long id, @RequestBody TitularDTO titularDTO){
        return titularService.alterarInfoTitular(id, titularDTO);
    }

}
