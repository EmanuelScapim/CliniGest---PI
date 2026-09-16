package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.AgendamentoDTO;
import io.github.projetopi.pi.model.Agendamento;
import io.github.projetopi.pi.model.Tratamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {

    @Mapping(source = "idDto", target = "id")
    @Mapping(source = "dataHoraDto", target = "dataHora")
    @Mapping(source = "statusAgendamentoDto", target = "statusAgendamento")
    @Mapping(source = "observacaoDto", target = "observacao")
    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "dentista", ignore = true)
    @Mapping(target = "tratamentos", ignore = true)
    @Mapping(target = "fatura", ignore = true)
    Agendamento toEntity(AgendamentoDTO dto);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "paciente.id", target = "pacienteIdDto")
    @Mapping(source = "dentista.id", target = "dentistaIdDto")
    @Mapping(source = "tratamentos", target = "tratamentoIdsDto")
    @Mapping(source = "dataHora", target = "dataHoraDto")
    @Mapping(source = "statusAgendamento", target = "statusAgendamentoDto")
    @Mapping(source = "observacao", target = "observacaoDto")
    AgendamentoDTO toDTO(Agendamento agendamento);

    default Set<UUID> tratamentosParaIds(Set<Tratamento> tratamentos){
        if(tratamentos == null){
            return Set.of();
        }

        return tratamentos.stream().map(Tratamento::getId).collect(Collectors.toSet());
    }

}
