package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MaterialRepository extends JpaRepository<Material, UUID> {

    @Query("select count(c) > 0 from ConsumoMaterial c where c.material.id = :id")
    boolean existsConsumoVinculado(@Param("id") UUID id);

}
