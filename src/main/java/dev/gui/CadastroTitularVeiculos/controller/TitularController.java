package dev.gui.CadastroTitularVeiculos.controller;

import dev.gui.CadastroTitularVeiculos.DTOs.TitularDTO;
import dev.gui.CadastroTitularVeiculos.service.TitularService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TitularDTO>> listarTitulares(){
        return ResponseEntity.ok(titularService.listarTitulares());
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarTitular(@RequestBody TitularDTO titularDTO){
        TitularDTO titular = titularService.criarTitular(titularDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("O titular " + titular.getNome() + " foi adicionado no evento");
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarTitularId(@PathVariable Long id){
        TitularDTO titular = titularService.listarTitularId(id);
        if(titular != null){
            return ResponseEntity.ok(titular);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O titular com o ID (" + id + ") não foi encontrado");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTitular(@PathVariable Long id){
        if(titularService.listarTitularId(id) != null){
            titularService.deletarTitular(id);
            ResponseEntity.ok("O titular com o ID (" + id + ") foi removido com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID: (" + id + ") não foi encontrado");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarInfoTitular(@PathVariable Long id, @RequestBody TitularDTO titularDTO){
        TitularDTO titular = titularService.listarTitularId(id);
        if(titular != null){
            titular = titularService.alterarInfoTitular(id, titularDTO);
            return ResponseEntity.ok(titular);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID: (" + id + ") não foi encontrado");
    }

}
