package io.github.projetopi.pi.service;

import io.github.projetopi.pi.model.ConsumoMaterial;
import io.github.projetopi.pi.model.Material;
import io.github.projetopi.pi.model.Tratamento;
import io.github.projetopi.pi.repository.ConsumoMaterialRepository;
import io.github.projetopi.pi.repository.MaterialRepository;
import io.github.projetopi.pi.repository.TratamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConsumoMaterialService {

    private final ConsumoMaterialRepository consumoMaterialRepository;
    private final MaterialRepository materialRepository;
    private final TratamentoRepository tratamentoRepository;

    public ConsumoMaterial cadastrarConsumoMaterial(ConsumoMaterial consumoMaterial, UUID materialId, UUID tratamentoId){
        consumoMaterial.setMaterial(buscarMaterial(materialId));
        consumoMaterial.setTratamento(buscarTratamento(tratamentoId));
        return consumoMaterialRepository.save(consumoMaterial);
    }

    public List<ConsumoMaterial> pesquisar(UUID materialId, UUID tratamentoId){
        if(materialId != null && tratamentoId != null){
            return consumoMaterialRepository.findByMaterialIdAndTratamentoId(materialId, tratamentoId);
        }

        if(materialId != null){
            return consumoMaterialRepository.findByMaterialId(materialId);
        }

        if(tratamentoId != null){
            return consumoMaterialRepository.findByTratamentoId(tratamentoId);
        }

        return consumoMaterialRepository.findAll();
    }

    @Transactional
    public void deletarPorId(UUID id){
        consumoMaterialRepository.deleteById(id);
    }

    public void atualizarConsumoMaterial(ConsumoMaterial consumoMaterial, UUID materialId, UUID tratamentoId){
        if(consumoMaterial.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que o consumo de material exista");
        }

        consumoMaterial.setMaterial(buscarMaterial(materialId));
        consumoMaterial.setTratamento(buscarTratamento(tratamentoId));
        consumoMaterialRepository.save(consumoMaterial);
    }

    public Optional<ConsumoMaterial> encontrarPorId(UUID id){
        return consumoMaterialRepository.findById(id);
    }

    private Material buscarMaterial(UUID id){
        return materialRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Material não encontrado"));
    }

    private Tratamento buscarTratamento(UUID id){
        return tratamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tratamento não encontrado"));
    }

}
