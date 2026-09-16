package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.AnamneseDTO;
import io.github.projetopi.pi.controller.mappers.AnamneseMapper;
import io.github.projetopi.pi.model.Anamnese;
import io.github.projetopi.pi.service.AnamneseService;
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
@RequestMapping("/anamneses")
@RequiredArgsConstructor
public class AnamneseController implements GenericController {

    private final AnamneseService anamneseService;
    private final AnamneseMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastrarAnamneseController(@RequestBody @Valid AnamneseDTO dto){
        Anamnese anamneseEntidade = mapper.toEntity(dto);
        anamneseEntidade = anamneseService.cadastrarAnamnese(anamneseEntidade, dto.pacienteIdDto());
        URI location = gerarHeaderLocation(anamneseEntidade.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnamneseDTO> buscarPorId(@PathVariable("id") String id){
        var idAnamnese = UUID.fromString(id);

        return anamneseService
                .encontrarPorId(idAnamnese)
                .map(anamnese -> ResponseEntity.ok(mapper.toDTO(anamnese)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AnamneseDTO>> listarAnamneseController(){
        List<Anamnese> anamnesesBuscadas = anamneseService.listarTodas();
        List<AnamneseDTO> lista = anamnesesBuscadas.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAnamneseController(@PathVariable("id") String id){
        var idAnamnese = UUID.fromString(id);
        Optional<Anamnese> anamneseOptional = anamneseService.encontrarPorId(idAnamnese);

        if(anamneseOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        anamneseService.deletarPorId(idAnamnese);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAnamneseController(@PathVariable("id") String id, @RequestBody @Valid AnamneseDTO dto){
        var idAnamnese = UUID.fromString(id);
        Optional<Anamnese> anamneseOptional = anamneseService.encontrarPorId(idAnamnese);

        if(anamneseOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var anamnese = anamneseOptional.get();
        anamnese.setAlergiasPaciente(dto.alergiasPacienteDto());
        anamnese.setHistoricoMedico(dto.historicoMedicoDto());
        anamnese.setMedicamentos(dto.medicamentosDto());
        anamnese.setDetalhes(dto.detalhesDto());

        anamneseService.atualizarAnamnese(anamnese);

        return ResponseEntity.noContent().build();
    }
}
