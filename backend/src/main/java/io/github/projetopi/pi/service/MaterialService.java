package io.github.projetopi.pi.service;

import io.github.projetopi.pi.exceptions.ExclusaoNaoPermitidaException;
import io.github.projetopi.pi.model.Material;
import io.github.projetopi.pi.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;

    public Material cadastrarMaterial(Material material){
        return materialRepository.save(material);
    }

    public List<Material> pesquisaByExample(String nome){
        var material = new Material();
        material.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Material> materialExample = Example.of(material, matcher);

        return materialRepository.findAll(materialExample);
    }

    @Transactional
    public void deletarPorId(UUID id){
        if(materialRepository.existsConsumoVinculado(id)){
            throw new ExclusaoNaoPermitidaException("Material possui consumo vinculado e não pode ser excluído");
        }

        materialRepository.deleteById(id);
    }

    public void atualizarMaterial(Material material){
        if(material.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessário que o material exista");
        }

        materialRepository.save(material);
    }

    public Optional<Material> encontrarPorId(UUID id){
        return materialRepository.findById(id);
    }

}
