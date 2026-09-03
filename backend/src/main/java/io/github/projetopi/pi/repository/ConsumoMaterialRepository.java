package io.github.projetopi.pi.repository;

import io.github.projetopi.pi.model.ConsumoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConsumoMaterialRepository extends JpaRepository<ConsumoMaterial, UUID>{

    List<ConsumoMaterial> findByMaterialIdAndTratamentoId(UUID materialId, UUID tratamentoId);

    List<ConsumoMaterial> findByMaterialId(UUID materialId);

    List<ConsumoMaterial> findByTratamentoId(UUID tratamentoId);

}
