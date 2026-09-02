package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.MaterialDTO;
import io.github.projetopi.pi.controller.mappers.MaterialMapper;
import io.github.projetopi.pi.model.Material;
import io.github.projetopi.pi.service.MaterialService;
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
@RequestMapping("/materiais")
@RequiredArgsConstructor
public class MaterialController implements GenericController {

    private final MaterialService materialService;
    private final MaterialMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastrarMaterialController(@RequestBody @Valid MaterialDTO dto){
        Material materialEntidade = mapper.toEntity(dto);
        materialEntidade = materialService.cadastrarMaterial(materialEntidade);
        URI location = gerarHeaderLocation(materialEntidade.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> buscarPorId(@PathVariable("id") String id){
        var idMaterial = UUID.fromString(id);

        return materialService
                .encontrarPorId(idMaterial)
                .map(material -> ResponseEntity.ok(mapper.toDTO(material)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MaterialDTO>> pesquisarMaterialController(@RequestParam(value = "nome", required = false) String nome){
        List<Material> materiaisBuscados = materialService.pesquisaByExample(nome);
        List<MaterialDTO> lista = materiaisBuscados.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarMaterialController(@PathVariable("id") String id){
        var idMaterial = UUID.fromString(id);
        Optional<Material> materialOptional = materialService.encontrarPorId(idMaterial);

        if(materialOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        materialService.deletarPorId(idMaterial);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarMaterialController(@PathVariable("id") String id, @RequestBody @Valid MaterialDTO dto){
        var idMaterial = UUID.fromString(id);
        Optional<Material> materialOptional = materialService.encontrarPorId(idMaterial);

        if(materialOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var material = materialOptional.get();
        material.setNome(dto.nomeMaterialDto());
        material.setQuantidadeMaterial(dto.quantidadeMaterialDto());

        materialService.atualizarMaterial(material);

        return ResponseEntity.noContent().build();
    }
}
