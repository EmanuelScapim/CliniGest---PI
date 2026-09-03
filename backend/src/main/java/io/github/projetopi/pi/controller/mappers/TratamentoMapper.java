package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.TratamentoDTO;
import io.github.projetopi.pi.model.Tratamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TratamentoMapper {

    @Mapping(source = "idDto", target = "id")
    @Mapping(source = "nomeTratamentoDto", target = "nomeTratamento")
    @Mapping(source = "descricaoDto", target = "descricao")
    @Mapping(source = "valorDto", target = "valor")
    Tratamento toEntity(TratamentoDTO dto);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "nomeTratamento", target = "nomeTratamentoDto")
    @Mapping(source = "descricao", target = "descricaoDto")
    @Mapping(source = "valor", target = "valorDto")
    TratamentoDTO toDTO(Tratamento tratamento);

}
