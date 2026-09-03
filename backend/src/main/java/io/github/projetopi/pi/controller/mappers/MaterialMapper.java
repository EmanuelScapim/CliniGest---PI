package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.MaterialDTO;
import io.github.projetopi.pi.model.Material;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

    @Mapping(source = "idDto", target = "id")
    @Mapping(source = "nomeMaterialDto", target = "nome")
    @Mapping(source = "quantidadeMaterialDto", target = "quantidadeMaterial")
    Material toEntity(MaterialDTO dto);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "nome", target = "nomeMaterialDto")
    @Mapping(source = "quantidadeMaterial", target = "quantidadeMaterialDto")
    MaterialDTO toDTO(Material material);

}
