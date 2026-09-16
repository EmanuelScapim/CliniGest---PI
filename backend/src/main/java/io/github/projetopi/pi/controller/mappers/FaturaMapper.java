package io.github.projetopi.pi.controller.mappers;

import io.github.projetopi.pi.controller.dto.FaturaDTO;
import io.github.projetopi.pi.model.Fatura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FaturaMapper {

    @Mapping(source = "idDto", target = "id")
    @Mapping(source = "valorTotalDto", target = "valor_total")
    @Mapping(source = "dataEmissaoDto", target = "dataEmissao")
    @Mapping(source = "statusPagamentoDto", target = "statusPagamento")
    @Mapping(source = "modoPagamentoDto", target = "modoPagamento")
    @Mapping(target = "agendamento", ignore = true)
    Fatura toEntity(FaturaDTO dto);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "agendamento.id", target = "agendamentoIdDto")
    @Mapping(source = "valor_total", target = "valorTotalDto")
    @Mapping(source = "dataEmissao", target = "dataEmissaoDto")
    @Mapping(source = "statusPagamento", target = "statusPagamentoDto")
    @Mapping(source = "modoPagamento", target = "modoPagamentoDto")
    FaturaDTO toDTO(Fatura fatura);

}
