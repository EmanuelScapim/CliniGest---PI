package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.OdontogramaDTO;
import io.github.projetopi.pi.model.Odontograma;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OdontogramaMapper {

    @Mapping(source = "idDto", target = "id")
    @Mapping(source = "imgOdontogramaDto", target = "imgOdontograma")
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "prontuario", ignore = true)
    Odontograma toEntity(OdontogramaDTO dto);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "paciente.id", target = "pacienteIdDto")
    @Mapping(source = "imgOdontograma", target = "imgOdontogramaDto")
    OdontogramaDTO toDTO(Odontograma odontograma);

}
