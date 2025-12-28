package dev.gui.CadastroTitularVeiculos.ui;

import dev.gui.CadastroTitularVeiculos.DTOs.TitularDTO;
import dev.gui.CadastroTitularVeiculos.service.TitularService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/titular/ui")
public class TitularUi {
    private final TitularService titularService;

    public TitularUi(TitularService titularService) {
        this.titularService = titularService;
    }

    @GetMapping("/listar")
    public String listarTitulares(Model model){
        List<TitularDTO> titulares = titularService.listarTitulares();
        model.addAttribute("titulares", titulares);
        return "listarTitulares";
    }

    @GetMapping("/listar/{id}")
    public String listarTitularesI(@PathVariable Long id, Model model){
        TitularDTO titular = titularService.listarTitularId(id);
        model.addAttribute("titular", titular);
        return "titularId";
    }

    @GetMapping("/criar")
    public String mostraPaginaCriarTitular(Model model){
        model.addAttribute("titular", new TitularDTO());
        return "criarTitular";
    }

    @PostMapping("/salvar")
    public String salvarTitular(@ModelAttribute TitularDTO titularDTO, RedirectAttributes redirectAttributes){
        titularService.criarTitular(titularDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Titular adicionado com sucesso!");
        return "redirect:/titular/ui/listar";
    }
}
