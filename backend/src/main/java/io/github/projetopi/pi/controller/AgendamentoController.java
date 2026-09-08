package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.AgendamentoDTO;
import io.github.projetopi.pi.controller.mappers.AgendamentoMapper;
import io.github.projetopi.pi.model.Agendamento;
import io.github.projetopi.pi.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController implements GenericController {

    private final AgendamentoService agendamentoService;
    private final AgendamentoMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastrarAgendamentoController(@RequestBody @Valid AgendamentoDTO dto){
        Agendamento agendamentoEntidade = mapper.toEntity(dto);
        agendamentoEntidade = agendamentoService.cadastrarAgendamento(agendamentoEntidade, dto.pacienteIdDto(), dto.dentistaIdDto(), dto.tratamentoIdsDto());
        URI location = gerarHeaderLocation(agendamentoEntidade.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> buscarPorId(@PathVariable("id") String id){
        var idAgendamento = UUID.fromString(id);

        return agendamentoService
                .encontrarPorId(idAgendamento)
                .map(agendamento -> ResponseEntity.ok(mapper.toDTO(agendamento)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> pesquisarAgendamentoController(@RequestParam(value = "pacienteNome", required = false) String pacienteNome,
                                                                                @RequestParam(value = "dentistaNome", required = false) String dentistaNome){
        List<Agendamento> agendamentosBuscados = agendamentoService.pesquisar(pacienteNome, dentistaNome);
        List<AgendamentoDTO> lista = agendamentosBuscados.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAgendamentoController(@PathVariable("id") String id){
        var idAgendamento = UUID.fromString(id);
        Optional<Agendamento> agendamentoOptional = agendamentoService.encontrarPorId(idAgendamento);

        if(agendamentoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        agendamentoService.deletarPorId(idAgendamento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAgendamentoController(@PathVariable("id") String id, @RequestBody @Valid AgendamentoDTO dto){
        var idAgendamento = UUID.fromString(id);
        Optional<Agendamento> agendamentoOptional = agendamentoService.encontrarPorId(idAgendamento);

        if(agendamentoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var agendamento = agendamentoOptional.get();
        agendamento.setDataHora(dto.dataHoraDto());
        agendamento.setDataHoraFim(dto.dataHoraFimDto());
        agendamento.setStatusAgendamento(dto.statusAgendamentoDto());
        agendamento.setObservacao(dto.observacaoDto());

        agendamentoService.atualizarAgendamento(agendamento, dto.pacienteIdDto(), dto.dentistaIdDto(), dto.tratamentoIdsDto());

        return ResponseEntity.noContent().build();
    }
}
