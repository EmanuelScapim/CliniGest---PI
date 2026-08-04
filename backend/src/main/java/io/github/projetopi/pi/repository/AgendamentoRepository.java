package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
}
