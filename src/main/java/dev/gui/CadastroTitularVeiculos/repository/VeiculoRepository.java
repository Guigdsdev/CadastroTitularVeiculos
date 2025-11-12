package dev.gui.CadastroTitularVeiculos.repository;

import dev.gui.CadastroTitularVeiculos.domain.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {
}
