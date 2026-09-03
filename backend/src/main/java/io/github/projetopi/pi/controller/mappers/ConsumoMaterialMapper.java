package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.ConsumoMaterialDTO;
import io.github.projetopi.pi.model.ConsumoMaterial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsumoMaterialMapper {

    @Mapping(source = "idDto", target = "id")
    @Mapping(source = "quantidadeDto", target = "quantidade")
    @Mapping(target = "material", ignore = true)
    @Mapping(target = "tratamento", ignore = true)
    ConsumoMaterial toEntity(ConsumoMaterialDTO dto);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "quantidade", target = "quantidadeDto")
    @Mapping(source = "material.id", target = "materialIdDto")
    @Mapping(source = "tratamento.id", target = "tratamentoIdDto")
    ConsumoMaterialDTO toDTO(ConsumoMaterial consumoMaterial);

}
