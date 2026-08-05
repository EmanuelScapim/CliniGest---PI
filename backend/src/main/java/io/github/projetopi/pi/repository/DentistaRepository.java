package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DentistaRepository extends JpaRepository<Dentista, UUID> {
}
