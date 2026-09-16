package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.ProntuarioDTO;
import io.github.projetopi.pi.controller.mappers.ProntuarioMapper;
import io.github.projetopi.pi.model.Prontuario;
import io.github.projetopi.pi.service.ProntuarioService;
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
@RequestMapping("/prontuarios")
@RequiredArgsConstructor
public class ProntuarioController implements GenericController {

    private final ProntuarioService prontuarioService;
    private final ProntuarioMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastrarProntuarioController(@RequestBody @Valid ProntuarioDTO dto){
        Prontuario prontuarioEntidade = mapper.toEntity(dto);
        prontuarioEntidade = prontuarioService.cadastrarProntuario(prontuarioEntidade, dto.pacienteIdDto(), dto.odontogramaIdDto(), dto.anamneseIdDto());
        URI location = gerarHeaderLocation(prontuarioEntidade.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioDTO> buscarPorId(@PathVariable("id") String id){
        var idProntuario = UUID.fromString(id);

        return prontuarioService
                .encontrarPorId(idProntuario)
                .map(prontuario -> ResponseEntity.ok(mapper.toDTO(prontuario)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProntuarioDTO>> listarProntuarioController(){
        List<Prontuario> prontuariosBuscados = prontuarioService.listarTodos();
        List<ProntuarioDTO> lista = prontuariosBuscados.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProntuarioController(@PathVariable("id") String id){
        var idProntuario = UUID.fromString(id);
        Optional<Prontuario> prontuarioOptional = prontuarioService.encontrarPorId(idProntuario);

        if(prontuarioOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        prontuarioService.deletarPorId(idProntuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProntuarioController(@PathVariable("id") String id, @RequestBody @Valid ProntuarioDTO dto){
        var idProntuario = UUID.fromString(id);
        Optional<Prontuario> prontuarioOptional = prontuarioService.encontrarPorId(idProntuario);

        if(prontuarioOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var prontuario = prontuarioOptional.get();

        prontuarioService.atualizarProntuario(prontuario, dto.odontogramaIdDto(), dto.anamneseIdDto());

        return ResponseEntity.noContent().build();
    }
}
