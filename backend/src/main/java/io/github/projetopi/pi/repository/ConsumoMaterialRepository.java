package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.ConsumoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsumoMaterialRepository extends JpaRepository<ConsumoMaterial, UUID>{
}
