package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.OdontogramaDTO;
import io.github.projetopi.pi.controller.mappers.OdontogramaMapper;
import io.github.projetopi.pi.model.Odontograma;
import io.github.projetopi.pi.service.OdontogramaService;
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
@RequestMapping("/odontogramas")
@RequiredArgsConstructor
public class OdontogramaController implements GenericController {

    private final OdontogramaService odontogramaService;
    private final OdontogramaMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastrarOdontogramaController(@RequestBody @Valid OdontogramaDTO dto){
        Odontograma odontogramaEntidade = mapper.toEntity(dto);
        odontogramaEntidade = odontogramaService.cadastrarOdontograma(odontogramaEntidade, dto.pacienteIdDto());
        URI location = gerarHeaderLocation(odontogramaEntidade.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontogramaDTO> buscarPorId(@PathVariable("id") String id){
        var idOdontograma = UUID.fromString(id);

        return odontogramaService
                .encontrarPorId(idOdontograma)
                .map(odontograma -> ResponseEntity.ok(mapper.toDTO(odontograma)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OdontogramaDTO>> listarOdontogramaController(){
        List<Odontograma> odontogramasBuscados = odontogramaService.listarTodos();
        List<OdontogramaDTO> lista = odontogramasBuscados.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarOdontogramaController(@PathVariable("id") String id){
        var idOdontograma = UUID.fromString(id);
        Optional<Odontograma> odontogramaOptional = odontogramaService.encontrarPorId(idOdontograma);

        if(odontogramaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        odontogramaService.deletarPorId(idOdontograma);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarOdontogramaController(@PathVariable("id") String id, @RequestBody @Valid OdontogramaDTO dto){
        var idOdontograma = UUID.fromString(id);
        Optional<Odontograma> odontogramaOptional = odontogramaService.encontrarPorId(idOdontograma);

        if(odontogramaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var odontograma = odontogramaOptional.get();
        odontograma.setImgOdontograma(dto.imgOdontogramaDto());

        odontogramaService.atualizarOdontograma(odontograma);

        return ResponseEntity.noContent().build();
    }
}
