package dev.gui.CadastroTitularVeiculos.controller;

import dev.gui.CadastroTitularVeiculos.DTOs.VeiculoDTO;
import dev.gui.CadastroTitularVeiculos.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<VeiculoDTO>>listarVeiculos(){
        return ResponseEntity.ok(veiculoService.listarVeiculos());
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarVeiculo(@RequestBody VeiculoDTO veiculoDTO){
        VeiculoDTO veiculo = veiculoService.criarVeiculo(veiculoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Veiculo: " + veiculo.getModelo() + " criado com sucesso!");
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarVeiculo(@PathVariable Long id){
        VeiculoDTO veiculo = veiculoService.listarVeiculoId(id);
        if(veiculo != null) {
            return ResponseEntity.ok(veiculo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo de ID (" + id + ") não encontrado");

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> removerVeiculo(@PathVariable Long id){
        VeiculoDTO veiculo = veiculoService.listarVeiculoId(id);
        if(veiculo != null) {
            veiculoService.removerVeiculo(id);
            return ResponseEntity.ok("Veiculo de ID (" + id + ") foi removido com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo de ID (" + id + ") não foi encontrado");

    }
}
