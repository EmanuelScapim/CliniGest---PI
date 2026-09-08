package io.github.projetopi.pi.validator;

import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Material;
import io.github.projetopi.pi.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MaterialValidator {

    private final MaterialRepository materialRepository;

    public void validaMaterial(Material material){
        if(pertenceAOutroMaterial(materialRepository.findByNomeIgnoreCase(material.getNome()), material.getId())){
            throw new RegistroDuplicadoException("Material já cadastrado");
        }
    }

    private boolean pertenceAOutroMaterial(Optional<Material> materialEncontrado, UUID id) {
        if(materialEncontrado.isEmpty()){
            return false;
        }

        if(id == null){
            return true;
        }

        return !id.equals(materialEncontrado.get().getId());
    }
}
