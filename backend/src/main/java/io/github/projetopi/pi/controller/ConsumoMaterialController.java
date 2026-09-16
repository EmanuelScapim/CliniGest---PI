package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.ConsumoMaterialDTO;
import io.github.projetopi.pi.controller.mappers.ConsumoMaterialMapper;
import io.github.projetopi.pi.model.ConsumoMaterial;
import io.github.projetopi.pi.service.ConsumoMaterialService;
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
@RequestMapping("/consumo-materiais")
@RequiredArgsConstructor
public class ConsumoMaterialController implements GenericController {

    private final ConsumoMaterialService consumoMaterialService;
    private final ConsumoMaterialMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastrarConsumoMaterialController(@RequestBody @Valid ConsumoMaterialDTO dto){
        ConsumoMaterial consumoMaterialEntidade = mapper.toEntity(dto);
        consumoMaterialEntidade = consumoMaterialService.cadastrarConsumoMaterial(consumoMaterialEntidade, dto.materialIdDto(), dto.tratamentoIdDto());
        URI location = gerarHeaderLocation(consumoMaterialEntidade.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoMaterialDTO> buscarPorId(@PathVariable("id") String id){
        var idConsumoMaterial = UUID.fromString(id);

        return consumoMaterialService
                .encontrarPorId(idConsumoMaterial)
                .map(consumoMaterial -> ResponseEntity.ok(mapper.toDTO(consumoMaterial)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ConsumoMaterialDTO>> pesquisarConsumoMaterialController(@RequestParam(value = "materialId", required = false) UUID materialId,
                                                                                        @RequestParam(value = "tratamentoId", required = false) UUID tratamentoId){
        List<ConsumoMaterial> consumosBuscados = consumoMaterialService.pesquisar(materialId, tratamentoId);
        List<ConsumoMaterialDTO> lista = consumosBuscados.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarConsumoMaterialController(@PathVariable("id") String id){
        var idConsumoMaterial = UUID.fromString(id);
        Optional<ConsumoMaterial> consumoMaterialOptional = consumoMaterialService.encontrarPorId(idConsumoMaterial);

        if(consumoMaterialOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        consumoMaterialService.deletarPorId(idConsumoMaterial);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarConsumoMaterialController(@PathVariable("id") String id, @RequestBody @Valid ConsumoMaterialDTO dto){
        var idConsumoMaterial = UUID.fromString(id);
        Optional<ConsumoMaterial> consumoMaterialOptional = consumoMaterialService.encontrarPorId(idConsumoMaterial);

        if(consumoMaterialOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var consumoMaterial = consumoMaterialOptional.get();
        consumoMaterial.setQuantidade(dto.quantidadeDto());

        consumoMaterialService.atualizarConsumoMaterial(consumoMaterial, dto.materialIdDto(), dto.tratamentoIdDto());

        return ResponseEntity.noContent().build();
    }
}
