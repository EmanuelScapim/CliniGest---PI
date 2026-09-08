package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.TratamentoDTO;
import io.github.projetopi.pi.controller.mappers.TratamentoMapper;
import io.github.projetopi.pi.model.Tratamento;
import io.github.projetopi.pi.service.TratamentoService;
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
@RequestMapping("/tratamentos")
@RequiredArgsConstructor
public class TratamentoController implements GenericController {

    private final TratamentoService tratamentoService;
    private final TratamentoMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastrarTratamentoController(@RequestBody @Valid TratamentoDTO dto){
        Tratamento tratamentoEntidade = mapper.toEntity(dto);
        tratamentoEntidade = tratamentoService.cadastrarTratamento(tratamentoEntidade);
        URI location = gerarHeaderLocation(tratamentoEntidade.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TratamentoDTO> buscarPorId(@PathVariable("id") String id){
        var idTratamento = UUID.fromString(id);

        return tratamentoService
                .encontrarPorId(idTratamento)
                .map(tratamento -> ResponseEntity.ok(mapper.toDTO(tratamento)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TratamentoDTO>> pesquisarTratamentoController(@RequestParam(value = "nome", required = false) String nome,
                                                                              @RequestParam(value = "descricao", required = false) String descricao){
        List<Tratamento> tratamentosBuscados = tratamentoService.pesquisaByExample(nome, descricao);
        List<TratamentoDTO> lista = tratamentosBuscados.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarTratamentoController(@PathVariable("id") String id){
        var idTratamento = UUID.fromString(id);
        Optional<Tratamento> tratamentoOptional = tratamentoService.encontrarPorId(idTratamento);

        if(tratamentoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        tratamentoService.deletarPorId(idTratamento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarTratamentoController(@PathVariable("id") String id, @RequestBody @Valid TratamentoDTO dto){
        var idTratamento = UUID.fromString(id);
        Optional<Tratamento> tratamentoOptional = tratamentoService.encontrarPorId(idTratamento);

        if(tratamentoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var tratamento = tratamentoOptional.get();
        tratamento.setNomeTratamento(dto.nomeTratamentoDto());
        tratamento.setDescricao(dto.descricaoDto());
        tratamento.setValor(dto.valorDto());

        tratamentoService.atualizarTratamento(tratamento);

        return ResponseEntity.noContent().build();
    }
}
