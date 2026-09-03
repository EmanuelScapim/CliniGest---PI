package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {
}
