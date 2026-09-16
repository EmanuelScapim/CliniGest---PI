package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.ProntuarioDTO;
import io.github.projetopi.pi.model.Prontuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProntuarioMapper {

    @Mapping(source = "idDto", target = "id")
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "odontograma", ignore = true)
    @Mapping(target = "anamnese", ignore = true)
    Prontuario toEntity(ProntuarioDTO dto);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "paciente.id", target = "pacienteIdDto")
    @Mapping(source = "odontograma.id", target = "odontogramaIdDto")
    @Mapping(source = "anamnese.id", target = "anamneseIdDto")
    ProntuarioDTO toDTO(Prontuario prontuario);

}
