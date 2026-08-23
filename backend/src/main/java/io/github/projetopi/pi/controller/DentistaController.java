package io.github.projetopi.pi.controller;


import io.github.projetopi.pi.controller.dto.DentistaDTO;
import io.github.projetopi.pi.controller.mappers.DentistaMapper;
import io.github.projetopi.pi.model.Dentista;
import io.github.projetopi.pi.service.DentistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("dentistas")
@RequiredArgsConstructor
public class DentistaController implements GenericController {

    private final DentistaService dentistaService;
    private final DentistaMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastraDentistaController(DentistaDTO dto){
        Dentista dentistaEntidade = mapper.toEntity(dto);
        URI location = gerarHeaderLocation(dentistaEntidade.getId());
        return  ResponseEntity.created(location).build();
    }

}
