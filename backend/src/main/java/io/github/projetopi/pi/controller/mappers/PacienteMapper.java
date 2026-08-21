package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.PacienteDTO;
import io.github.projetopi.pi.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacienteMapper {


    @Mapping(source = "idDTO", target = "id")
    @Mapping(source = "nomePacienteDto", target = "nomePessoa")
    @Mapping(source = "cpfPacienteDto", target = "cpf")
    @Mapping(source = "telefonePacienteDto", target = "telefonePessoa")
    @Mapping(source = "emailPacienteDto", target = "emailPessoa")
    @Mapping(source = "dataNascimentoPacienteDto", target = "dataNascimento")
    Paciente toEntity(PacienteDTO dto);


    @Mapping(source = "id", target = "idDTO")
    @Mapping(source = "nomePessoa", target = "nomePacienteDto")
    @Mapping(source = "cpf", target = "cpfPacienteDto")
    @Mapping(source = "telefonePessoa", target = "telefonePacienteDto")
    @Mapping(source = "emailPessoa", target = "emailPacienteDto")
    @Mapping(source = "dataNascimento", target = "dataNascimentoPacienteDto")
    PacienteDTO toDTO(Paciente paciente);
}
