package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.FaturaDTO;
import io.github.projetopi.pi.controller.mappers.FaturaMapper;
import io.github.projetopi.pi.model.Fatura;
import io.github.projetopi.pi.service.FaturaService;
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
@RequestMapping("/faturas")
@RequiredArgsConstructor
public class FaturaController implements GenericController {

    private final FaturaService faturaService;
    private final FaturaMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastrarFaturaController(@RequestBody @Valid FaturaDTO dto){
        Fatura faturaEntidade = mapper.toEntity(dto);
        faturaEntidade = faturaService.cadastrarFatura(faturaEntidade, dto.agendamentoIdDto());
        URI location = gerarHeaderLocation(faturaEntidade.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaturaDTO> buscarPorId(@PathVariable("id") String id){
        var idFatura = UUID.fromString(id);

        return faturaService
                .encontrarPorId(idFatura)
                .map(fatura -> ResponseEntity.ok(mapper.toDTO(fatura)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FaturaDTO>> listarFaturaController(){
        List<Fatura> faturasBuscadas = faturaService.listarTodas();
        List<FaturaDTO> lista = faturasBuscadas.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarFaturaController(@PathVariable("id") String id){
        var idFatura = UUID.fromString(id);
        Optional<Fatura> faturaOptional = faturaService.encontrarPorId(idFatura);

        if(faturaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        faturaService.deletarPorId(idFatura);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarFaturaController(@PathVariable("id") String id, @RequestBody @Valid FaturaDTO dto){
        var idFatura = UUID.fromString(id);
        Optional<Fatura> faturaOptional = faturaService.encontrarPorId(idFatura);

        if(faturaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var fatura = faturaOptional.get();
        fatura.setValor_total(dto.valorTotalDto());
        fatura.setDataEmissao(dto.dataEmissaoDto());
        fatura.setStatusPagamento(dto.statusPagamentoDto());
        fatura.setModoPagamento(dto.modoPagamentoDto());

        faturaService.atualizarFatura(fatura);

        return ResponseEntity.noContent().build();
    }
}
