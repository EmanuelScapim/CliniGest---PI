package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.AnamneseDTO;
import io.github.projetopi.pi.model.Anamnese;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnamneseMapper {

    @Mapping(source = "idDto", target = "id")
    @Mapping(source = "alergiasPacienteDto", target = "alergiasPaciente")
    @Mapping(source = "historicoMedicoDto", target = "historicoMedico")
    @Mapping(source = "medicamentosDto", target = "medicamentos")
    @Mapping(source = "detalhesDto", target = "detalhes")
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "prontuario", ignore = true)
    Anamnese toEntity(AnamneseDTO dto);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "paciente.id", target = "pacienteIdDto")
    @Mapping(source = "alergiasPaciente", target = "alergiasPacienteDto")
    @Mapping(source = "historicoMedico", target = "historicoMedicoDto")
    @Mapping(source = "medicamentos", target = "medicamentosDto")
    @Mapping(source = "detalhes", target = "detalhesDto")
    AnamneseDTO toDTO(Anamnese anamnese);

}
