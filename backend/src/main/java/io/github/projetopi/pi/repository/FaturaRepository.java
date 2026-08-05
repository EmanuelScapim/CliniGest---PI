package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FaturaRepository extends JpaRepository<Fatura, UUID> {
}
