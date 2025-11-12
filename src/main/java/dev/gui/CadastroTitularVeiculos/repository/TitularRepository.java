package dev.gui.CadastroTitularVeiculos.repository;

import dev.gui.CadastroTitularVeiculos.domain.TitularModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<TitularModel, Long> {
}
