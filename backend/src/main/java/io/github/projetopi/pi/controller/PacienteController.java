package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> cadastarPacienteController(@RequestBody Paciente paciente){
        pacienteService.cadastrarPacienteService(paciente);

        return  ResponseEntity.ok().body(paciente);
    }
}
