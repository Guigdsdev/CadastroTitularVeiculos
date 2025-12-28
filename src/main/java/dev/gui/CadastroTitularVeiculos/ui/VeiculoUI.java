package dev.gui.CadastroTitularVeiculos.ui;

import dev.gui.CadastroTitularVeiculos.DTOs.VeiculoDTO;
import dev.gui.CadastroTitularVeiculos.service.VeiculoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/veiculos/ui")
public class VeiculoUI {

    private final VeiculoService veiculoService;

    public VeiculoUI(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping("/criar")
    public String mostrarPagina(Model model){
        model.addAttribute("veiculo", new VeiculoDTO());
        return "criarVeiculo";
    }

    @PostMapping("/salvar")
    public String salvarVeiculo(@ModelAttribute VeiculoDTO veiculoDTO, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("mensagem", "Veículo adicionado com sucesso");
        veiculoService.criarVeiculo(veiculoDTO);
        return "redirect:/titular/ui/listar";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarVeiculo(@PathVariable Long id){
        veiculoService.removerVeiculo(id);
        return "redirect:/titular/ui/listar";
    }
}
