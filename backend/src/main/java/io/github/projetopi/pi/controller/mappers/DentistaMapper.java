package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.DentistaDTO;
import io.github.projetopi.pi.model.Dentista;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DentistaMapper {

    @Mapping(source = "idDto", target = "id")
    @Mapping(source = "nomeDentistaDto", target = "nomePessoa")
    @Mapping(source = "cpfDentistaDto", target = "cpf")
    @Mapping(source = "telefoneDentistaDto", target = "telefonePessoa")
    @Mapping(source = "emailDentistaDto", target = "emailPessoa")
    @Mapping(source = "dataNascimentoDentistaDto", target = "dataNascimento")
    @Mapping(source = "croDentistaDto", target = "cro")
    @Mapping(source = "especialidadeDentistaDto", target = "especialidade")
    Dentista toEntity(DentistaDTO dto);


    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "nomePessoa", target = "nomeDentistaDto")
    @Mapping(source = "cpf", target = "cpfDentistaDto")
    @Mapping(source = "telefonePessoa", target = "telefoneDentistaDto")
    @Mapping(source = "emailPessoa", target = "emailDentistaDto")
    @Mapping(source = "dataNascimento", target = "dataNascimentoDentistaDto")
    @Mapping(source = "cro", target = "croDentistaDto")
    @Mapping(source = "especialidade", target = "especialidadeDentistaDto")
    DentistaDTO toDTO(Dentista dentista);

}
